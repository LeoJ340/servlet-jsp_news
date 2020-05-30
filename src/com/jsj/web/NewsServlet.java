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
import java.util.List;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    private NewsService newsService = (NewsService) ServiceFactory.getService("NewsService");

    private NewsCateService newsCateService = (NewsCateService) ServiceFactory.getService("NewsCateService");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int newsId = Integer.parseInt(request.getParameter("newsId"));
            News news = newsService.getNewsById(newsId);
            if (news == null){
                request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
            }else {
                request.setAttribute("news",news);
                List<NewsCate> allCate = newsCateService.getAllCate();
                request.setAttribute("allCate",allCate);
                request.getRequestDispatcher("/WEB-INF/view/news.jsp").forward(request,response);
            }
        }catch (Exception e){
            request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
        }

    }
}
