package com.jsj.web;

import com.jsj.entity.News;
import com.jsj.factory.ServiceFactory;
import com.jsj.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    private NewsService newsService = ServiceFactory.getNewsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(request.getParameter("newsId"));
        try {
            News news = newsService.getNewsById(newsId);
            request.setAttribute("news",news);
            request.getRequestDispatcher("news.jsp").forward(request,response);
        } catch (SQLException e) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("网络异常，请稍后重试");
            response.setHeader("refresh", "2;url=/index.jsp");
        }
    }

}
