package com.jsj.web.manage;

import com.jsj.entity.Admin;
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
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/admin/manage/publish")
public class PublishNewsServlet extends HttpServlet {

    private NewsCateService newsCateService = ServiceFactory.getNewsCateService();

    private NewsService newsService = ServiceFactory.getNewsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NewsCate> allCate = newsCateService.getAllCate();
        request.setAttribute("allCate",allCate);
        request.getRequestDispatcher("/admin/manage/publish.jsp").forward(request,response);
    }


    /**
     * 发表文章
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try(PrintWriter out = response.getWriter()){
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            News news = new News();
            news.setTitle(request.getParameter("title"));
            news.setAuthor(admin.getUsername());
            news.setCateId(Integer.valueOf(request.getParameter("cate")));
            news.setTime(new Date());
            news.setContent(request.getParameter("content"));
            System.out.println(news);
            int res = newsService.publish(news);
            if (res>0){
                out.println("新闻发表成功");
                response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
            }else {
                out.println("新闻发表失败");
                response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
            }
        }
    }

}
