package com.jsj.web;

import com.jsj.entity.User;
import com.jsj.factory.ServiceFactory;
import com.jsj.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = ServiceFactory.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        try {
            User user = userService.login(username,password);
            if (user.getId()!=null){
                out.println("登录成功，3秒后跳转到首页！如果没有跳转请点<a href='/index'>这里</a>");
                request.getSession().setAttribute("status","user");
                request.getSession().setAttribute("user",user);
                response.setHeader("refresh", "2;url=/index.jsp");
            }else {
                out.println("用户名或密码错误，请重试");
                response.setHeader("refresh", "2;url=/login.jsp");
            }
        }catch (SQLException e){
            out.println("连接异常，请稍后重试");
            response.setHeader("refresh", "2;url=/login.jsp");
        }
    }
}