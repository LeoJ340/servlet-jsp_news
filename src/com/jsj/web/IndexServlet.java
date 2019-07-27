package com.jsj.web;

import com.jsj.entity.NewsVm;
import com.jsj.entity.NewsCate;
import com.jsj.factory.ServiceFactory;
import com.jsj.service.NewsCateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    private NewsCateService newsCateService = ServiceFactory.getNewsCateService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<NewsCate> allCate = newsCateService.getAllCate();
        request.getSession().setAttribute("allCate",allCate);
        List<NewsVm> allNewsVm = newsCateService.getNewsVmList();
        request.getSession().setAttribute("allNewsVm", allNewsVm);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
