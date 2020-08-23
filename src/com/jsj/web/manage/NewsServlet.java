package com.jsj.web.manage;

import com.jsj.entity.News;
import com.jsj.entity.NewsCate;
import com.jsj.entity.NewsVo;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/manage/news")
public class NewsServlet extends HttpServlet {

    private NewsService newsService = (NewsService) ServiceFactory.getService("NewsService");

    private NewsCateService newsCateService = (NewsCateService) ServiceFactory.getService("NewsCateService");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer newsId = Integer.parseInt(request.getParameter("newsId"));
            List<NewsCate> allCate = newsCateService.getAllCate();
            NewsVo newsVo = new NewsVo();
            News news = newsService.getNewsById(newsId);
            newsVo.setId(news.getId());
            newsVo.setTitle(news.getTitle());
            newsVo.setAuthor(news.getAuthor());
            newsVo.setContent(news.getContent());
            newsVo.setTime(news.getTime());
            newsVo.setCateId(news.getCateId());
            NewsCate newsCate = newsCateService.getNewsCateById(news.getCateId());
            newsVo.setNewsCate(newsCate);
            // 把当前新闻的分类移到所有分类的第一个
            allCate.remove(newsCate);
            allCate.listIterator().add(newsCate);

            request.setAttribute("allCate",allCate);
            request.setAttribute("news",newsVo);
            request.setAttribute("isEdit",true);
            request.getRequestDispatcher("/WEB-INF/view/admin/manage/publish.jsp").forward(request,response);
        }catch (NumberFormatException nfe){
            try{
                int pageIndex = request.getParameter("pageIndex") == null ? 1 : Integer.parseInt(request.getParameter("pageIndex"));
                int pageSize = 10;
                Page<NewsVo> newsVoPage = newsService.getNewsVoPage(pageIndex,pageSize);
                if (newsVoPage.getBeanList() == null || newsVoPage.getBeanList().size() == 0){
                    request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
                }else {
                    request.setAttribute("newsVoPage", newsVoPage);
                    request.getRequestDispatcher("/WEB-INF/view/admin/manage/news.jsp").forward(request,response);
                }
            }catch (Exception e){
                request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
            }
        }
    }

    /**
     * 删除新闻文章
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            Integer id = Integer.valueOf(request.getParameter("id"));
            int res = newsService.deleteNewsById(id);
            if (res>0){
                out.println("新闻删除成功");
            }else {
                out.println("新闻删除失败");
            }
            response.setHeader("refresh", "2;url="+request.getContextPath()+"/admin/manage/news");
        }
    }


}
