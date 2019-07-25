package com.jsj.web.manage;

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
import java.util.List;

@WebServlet("/admin/manage/news")
public class NewsServlet extends HttpServlet {

    private NewsService newsService = ServiceFactory.getNewsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<News> allNews = newsService.getAllNews();
            request.getSession().setAttribute("allNews",allNews);
            request.getRequestDispatcher("/admin/manage/news.jsp").forward(request,response);
        } catch (SQLException e) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("网络异常，请稍后重试");
            response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
        }
    }

    /**
     * 删除新闻文章
     * @param request
     * @param response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);

    }


}
