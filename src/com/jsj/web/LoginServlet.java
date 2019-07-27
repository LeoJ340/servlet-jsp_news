package com.jsj.web;

import com.jsj.entity.User;
import com.jsj.factory.ServiceFactory;
import com.jsj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = ServiceFactory.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userService.login(username,password);
            if (user!=null){
                if (request.getParameter("remember")!=null){
                    Cookie usernameCookie = new Cookie("rememberUsername",username);
                    usernameCookie.setMaxAge(7*24*60*60);
                    Cookie passwordCookie = new Cookie("rememberPassword",password);
                    passwordCookie.setMaxAge(7*24*60*60);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                }
                out.println("登录成功，3秒后跳转到首页！如果没有跳转请点<a href='/index'>这里</a>");
                request.getSession().setAttribute("userStatus",true);
                request.getSession().setAttribute("user",user);
                response.setHeader("refresh", "2;url=/index.jsp");
            }else {
                out.println("用户名或密码错误，请重试");
                response.setHeader("refresh", "2;url=/login.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("rememberUsername")){
                request.setAttribute("rememberUsername",cookie.getValue());
            }
            if (cookie.getName().equals("rememberPassword")){
                request.setAttribute("rememberPassword",cookie.getValue());
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}