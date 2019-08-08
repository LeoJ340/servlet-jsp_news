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
import java.util.List;

@WebServlet("/admin/manage/newsCate")
public class NewsCateServlet extends HttpServlet {

    private NewsCateService newsCateService = ServiceFactory.getNewsCateService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NewsCate> allCate = newsCateService.getAllCate();
        request.getSession().setAttribute("allCate",allCate);
        request.getRequestDispatcher("/admin/manage/newsCate.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try(PrintWriter out = response.getWriter()){
            if (request.getParameter("method")!=null&&request.getParameter("method").equals("insert")){
                //添加新闻分类
                insert(request,response,out);
            }else if (request.getParameter("name")!=null){
                //修改分类
                update(request,response,out);
            }else {
                //删除分类
                delete(request,response,out);
            }
        }
    }

    /**
     * 添加分类
     */
    public void insert(HttpServletRequest request,HttpServletResponse response,PrintWriter out) {
        String name = request.getParameter("name");
        NewsCate newsCate = new NewsCate();
        newsCate.setName(name);
        int res = newsCateService.insert(newsCate);
        if (res>0){
            out.println("添加成功");
            response.setHeader("refresh", "2;url=/admin/manage/newsCate");
        }else {
            out.println("添加失败");
            response.setHeader("refresh", "2;url=/admin/manage/newsCate");
        }
    }

    /**
     * 删除分类
     */
    public void delete(HttpServletRequest request,HttpServletResponse response,PrintWriter out) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        int res = newsCateService.delete(id);
        if (res>0){
            out.println("删除成功");
            response.setHeader("refresh", "2;url=/admin/manage/newsCate");
        }else {
            out.println("添加失败");
            response.setHeader("refresh", "2;url=/admin/manage/newsCate");
        }
    }

    /**
     * 修改分类
     */
    public void update(HttpServletRequest request,HttpServletResponse response,PrintWriter out) {
        String name = request.getParameter("name");
        Integer id = Integer.valueOf(request.getParameter("id"));
        NewsCate newsCate = new NewsCate();
        newsCate.setId(id);
        newsCate.setName(name);
        int res = newsCateService.update(newsCate);
        if (res>0){
            out.println("修改成功");
            response.setHeader("refresh", "2;url=/admin/manage/newsCate");
        }else {
            out.println("修改失败");
            response.setHeader("refresh", "2;url=/admin/manage/newsCate");
        }
    }

}
