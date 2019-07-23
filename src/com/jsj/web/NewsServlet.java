package com.jsj.web;

import com.jsj.entity.Admin;
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
import java.util.Date;

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String methodName = request.getParameter("method");
        //反射方法
        publish(request,response);
    }

    /**
     * 发表文章方法
     * @param request
     * @param response
     */
    public void publish(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        News news = new News();
        news.setTitle(request.getParameter("title"));
        news.setAuthor(admin.getUsername());
        news.setCateId(Integer.valueOf(request.getParameter("cate")));
        news.setTime(new Date());
        news.setContent(request.getParameter("content"));
        try {
            int res = newsService.publish(news);
            if (res>0){
                out.println("新闻发表成功");
                response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
            }else {
                out.println("新闻发表失败");
                response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
            }
        } catch (SQLException e) {
            out.println("网络异常，请稍后重试");
            response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
        }
    }

}
