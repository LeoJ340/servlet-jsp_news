package com.jsj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/manage/*")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getSession().getAttribute("adminStatus")!=null&& (boolean) request.getSession().getAttribute("adminStatus"))
            filterChain.doFilter(servletRequest, servletResponse);
        else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("您不是管理员，无权访问该资源！");
            response.setHeader("refresh", "2;url=/admin/login.jsp");
        }
    }

}
