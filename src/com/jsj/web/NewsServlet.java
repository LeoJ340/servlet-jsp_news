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

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    private NewsService newsService = ServiceFactory.getNewsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(request.getParameter("newsId"));
        News news = newsService.getNewsById(newsId);
        request.setAttribute("news",news);
        request.getRequestDispatcher("news.jsp").forward(request,response);
    }
}
