package com.jsj.web;

import com.jsj.entity.NewsCateVo;
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
        List<NewsCate> allCate = newsCateService.getAllCate();
        request.setAttribute("allCate",allCate);
        List<NewsCateVo> allNewsCateVo = newsCateService.getAllNewsCateVo(5);
        request.setAttribute("allNewsCateVo", allNewsCateVo);
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request,response);
    }

}
