package com.jsj.web.manage;

import com.jsj.entity.NewsCate;
import com.jsj.factory.ServiceFactory;
import com.jsj.service.NewsCateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/manage/newsCate")
public class NewsCateServlet extends HttpServlet {

    private NewsCateService newsCateService = ServiceFactory.getNewsCateService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<NewsCate> allCate = newsCateService.getAllCate();
            request.getSession().setAttribute("allCate",allCate);
            request.getRequestDispatcher("/admin/manage/newsCate.jsp").forward(request,response);
        } catch (SQLException e) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("网络异常，请稍后重试");
            response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("method")!=null&&request.getParameter("method").equals("insert")){

        }else if (request.getParameter("name")!=null){
            String name = request.getParameter("name");
            Integer id = Integer.valueOf(request.getParameter("id"));

        }else {
            Integer id = Integer.valueOf(request.getParameter("id"));

        }
    }
}
