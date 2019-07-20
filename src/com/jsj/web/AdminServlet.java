package com.jsj.web;

import com.jsj.entity.Admin;
import com.jsj.factory.ServiceFactory;
import com.jsj.service.AdminService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private AdminService adminService = ServiceFactory.getAdminService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Admin admin = adminService.login(username,password);
            if (admin.getId()!=null){
                request.getSession().setAttribute("adminStatus",true);
                request.getSession().setAttribute("admin",admin);
                out.println("登录成功，3秒后跳转到首页！如果没有跳转请点<a href='/admin/index.jsp'>这里</a>");
                response.setHeader("refresh", "2;url=/admin/index.jsp");
            }else {
                out.println("用户名或密码错误，请重试");
                response.setHeader("refresh", "2;url=/admin/login.jsp");
            }
        } catch (SQLException e) {
            out.println("连接异常，请稍后重试");
            response.setHeader("refresh", "2;url=/admin/login.jsp");
        }
    }

}
