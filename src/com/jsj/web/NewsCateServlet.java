package com.jsj.web;

import com.jsj.entity.News;
import com.jsj.entity.NewsCate;
import com.jsj.entity.Page;
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

@WebServlet("/newsCate")
public class NewsCateServlet extends HttpServlet {

    private NewsService newsService = (NewsService) ServiceFactory.getService("NewsService");

    private NewsCateService newsCateService = (NewsCateService) ServiceFactory.getService("NewsCateService");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NewsCate> allCate = newsCateService.getAllCate();
        request.setAttribute("allCate",allCate);
        Integer cateId = Integer.valueOf(request.getParameter("cateId"));
        NewsCate newsCate = newsCateService.getNewsCateById(cateId);
        request.setAttribute("cate",newsCate);
        int pageIndex = 1;
        if (request.getParameter("pageIndex") != null){
            pageIndex = Integer.valueOf(request.getParameter("pageIndex")) < 1 ? 1 : Integer.valueOf(request.getParameter("pageIndex"));
        }
        int pageSize = 10;
        if (request.getParameter("pageSize") != null){
            pageSize = Integer.valueOf(request.getParameter("pageSize")) < 1 ? 10 : Integer.valueOf(request.getParameter("pageSize"));
        }
        Page<News> newsPage = newsService.getNewsPageByCate(cateId,pageIndex,pageSize);
        request.setAttribute("newsPage", newsPage);
        request.getRequestDispatcher("/WEB-INF/view/newsCate.jsp").forward(request,response);
    }
}
