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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("method")!=null&&request.getParameter("method").equals("insert")){
            //添加新闻分类
            insert(request,response);
        }else if (request.getParameter("name")!=null){
            //修改分类
            update(request,response);
        }else {
            //删除分类
            delete(request,response);
        }
    }

    /**
     * 添加分类
     */
    public void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        NewsCate newsCate = new NewsCate();
        newsCate.setName(name);
        try {
            int res = newsCateService.insert(newsCate);
            if (res>0){
                response.getWriter().println("添加成功");
                response.setHeader("refresh", "2;url=/admin/manage/newsCate");
            }else {
                response.getWriter().println("添加失败");
                response.setHeader("refresh", "2;url=/admin/manage/newsCate");
            }
        } catch (SQLException e) {
            response.getWriter().println("网络异常，请稍后重试");
            response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
        }
    }

    /**
     * 删除分类
     */
    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            int res = newsCateService.delete(id);
            if (res>0){
                response.getWriter().println("删除成功");
                response.setHeader("refresh", "2;url=/admin/manage/newsCate");
            }else {
                response.getWriter().println("添加失败");
                response.setHeader("refresh", "2;url=/admin/manage/newsCate");
            }
        } catch (SQLException e) {
            response.getWriter().println("网络异常，请稍后重试");
            response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
        }
    }

    /**
     * 修改分类
     */
    public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer id = Integer.valueOf(request.getParameter("id"));
        NewsCate newsCate = new NewsCate();
        newsCate.setId(id);
        newsCate.setName(name);
        try {
            int res = newsCateService.update(newsCate);
            if (res>0){
                response.getWriter().println("修改成功");
                response.setHeader("refresh", "2;url=/admin/manage/newsCate");
            }else {
                response.getWriter().println("修改失败");
                response.setHeader("refresh", "2;url=/admin/manage/newsCate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("网络异常，请稍后重试");
            response.setHeader("refresh", "2;url=/admin/manage/index.jsp");
        }
    }

}
