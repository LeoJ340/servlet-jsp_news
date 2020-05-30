package com.jsj.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("user")!=null){
            request.getSession().removeAttribute("userStatus");
            request.getSession().removeAttribute("user");
        }
        if (request.getSession().getAttribute("admin")!=null){
            request.getSession().removeAttribute("adminStatus");
            request.getSession().removeAttribute("admin");
        }
        response.getWriter().println("注销成功，3秒后跳转到首页！如果没有跳转请点<a href='"+request.getContextPath()+"/'>这里</a>");
        response.setHeader("refresh", "2;url=/");
    }
}
