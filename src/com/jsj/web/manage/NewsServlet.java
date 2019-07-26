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
import java.io.PrintWriter;
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
            try(PrintWriter out = response.getWriter()){
                response.setContentType("text/html;charset=UTF-8");
                out.println("网络异常，请稍后重试");
                response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
            }
        }
    }

    /**
     * 删除新闻文章
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            try {
                Integer id = Integer.valueOf(request.getParameter("id"));
                int res = newsService.deleteNewsById(id);
                if (res>0){
                    out.println("新闻删除成功");
                    response.setHeader("refresh", "2;url=/admin/manage/news");
                }else {
                    out.println("新闻删除失败");
                    response.setHeader("refresh", "2;url=/admin/manage/news");
                }
            } catch (SQLException e) {
                out.println("网络异常，请稍后重试");
                response.setHeader("refresh", "2;url=/admin/manage/news");
            }
        }
    }


}
