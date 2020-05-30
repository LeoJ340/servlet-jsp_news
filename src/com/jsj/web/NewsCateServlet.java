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
        try {
            int cateId = Integer.parseInt(request.getParameter("cateId"));
            NewsCate newsCate = newsCateService.getNewsCateById(cateId);
            if (newsCate == null){
                request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
            }else {
                int pageIndex = request.getParameter("pageIndex") == null ? 1 : Integer.parseInt(request.getParameter("pageIndex"));
                int pageSize = 10;
                Page<News> newsPage = newsService.getNewsPageByCate(cateId,pageIndex,pageSize);
                if (newsPage.getBeanList() == null || newsPage.getBeanList().size() == 0){
                    request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
                }
                request.setAttribute("newsPage", newsPage);
                request.setAttribute("cate",newsCate);
                List<NewsCate> allCate = newsCateService.getAllCate();
                request.setAttribute("allCate",allCate);
                request.getRequestDispatcher("/WEB-INF/view/newsCate.jsp").forward(request,response);
            }
        }catch (Exception e){
            request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
        }

    }
}
