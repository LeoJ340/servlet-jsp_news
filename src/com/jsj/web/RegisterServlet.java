package com.jsj.web;

import com.jsj.entity.User;
import com.jsj.factory.ServiceFactory;
import com.jsj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = (UserService) ServiceFactory.getService("UserService");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthday(dateFormat.parse(request.getParameter("birthday")));
            } catch (ParseException ignored) {}
            user.setEmail(request.getParameter("email"));
            user.setTelNumber(request.getParameter("telNumber"));
            int res = userService.register(user);
            if (res>0){
                out.println("注册成功，3秒后跳转到首页！或现在去<a href='"+request.getContextPath()+"/login'>登录</a>");
                response.setHeader("refresh", "2;url="+request.getContextPath()+"/");
            }else {
                out.println("注册失败!请<a href='"+request.getContextPath()+"/register'>重试</a>");
                response.setHeader("refresh", "2;url="+request.getContextPath()+"/register");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request,response);
    }
}
