package com.jsj.web;

import com.jsj.entity.News;
import com.jsj.entity.NewsCate;
import com.jsj.factory.ServiceFactory;
import com.jsj.service.NewsCateService;
import com.jsj.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/newsCate")
public class NewsCateServlet extends HttpServlet {

    private NewsService newsService = ServiceFactory.getNewsService();

    private NewsCateService newsCateService = ServiceFactory.getNewsCateService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer cateId = Integer.valueOf(request.getParameter("cateId"));
        try {
            NewsCate newsCate = newsCateService.getNewsCateById(cateId);
            List<News> newsList = newsService.getNewsListByCate(cateId);
            request.setAttribute("newsList",newsList);
            request.setAttribute("cateName",newsCate.getName());
            request.getRequestDispatcher("newsCate.jsp").forward(request,response);
        } catch (SQLException e) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("网络异常，请稍后重试");
            response.setHeader("refresh", "2;url=/index.jsp");
        }
    }
}
