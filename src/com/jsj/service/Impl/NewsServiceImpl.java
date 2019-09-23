package com.jsj.service.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.dao.NewsDao;
import com.jsj.entity.News;
import com.jsj.entity.NewsVo;
import com.jsj.entity.Page;
import com.jsj.factory.DaoFactory;
import com.jsj.service.NewsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao = DaoFactory.getNewsDao();

    private NewsCateDao newsCateDao = DaoFactory.getNewsCateDao();

    @Override
    public Page<NewsVo> getNewsVoPage(Integer pageIndex, Integer pageSize) {
        Page <NewsVo> newsVoPage = new Page <>();
        newsVoPage.setPageIndex(pageIndex);
        newsVoPage.setPageSize(pageSize);
        newsVoPage.setBeanList(getNewsVoList((pageIndex - 1) * pageSize, pageSize));
        try {
            newsVoPage.setTotalCount(newsDao.getCount());
            newsVoPage.setTotalPage((int) Math.ceil((double) newsDao.getCount() / (double) pageSize));
        } catch (SQLException e) {
            return null;
        }
        return newsVoPage;
    }

    @Override
    public Page<News> getNewsPageByCate(Integer cateId, Integer pageIndex, Integer pageSize) {
        Page<News> newsPage = new Page<> ();
        newsPage.setPageIndex(pageIndex);
        newsPage.setPageSize(pageSize);
        newsPage.setBeanList(getNewsListByCate(cateId,(pageIndex - 1) * pageSize,pageSize));
        try {
            newsPage.setTotalCount(newsDao.getCountByCate(cateId));
            newsPage.setTotalPage((int) Math.ceil((double) newsDao.getCountByCate(cateId) / (double) pageSize));
        } catch (SQLException e) {
            return null;
        }
        return newsPage;
    }

    @Override
    public List<NewsVo> getNewsVoList(Integer pageIndex, Integer length) {
        List <NewsVo> newsVoList = new ArrayList<> ();
        try {
            List<News> newsList = newsDao.getNewsList(pageIndex, length);
            for (News news : newsList){
                NewsVo newsVo = new NewsVo();
                newsVo.setNewsCate(newsCateDao.getById(news.getCateId()));
                newsVo.setTitle(news.getTitle());
                newsVo.setContent(news.getContent());
                newsVo.setAuthor(news.getAuthor());
                newsVo.setTime(news.getTime());
                newsVo.setId(news.getId());
                newsVo.setCateId(news.getCateId());
                newsVoList.add(newsVo);
            }
        } catch (SQLException e) {
            return null;
        }
        return newsVoList;
    }

    @Override
    public List<News> getNewsListByCate(Integer cateId,Integer pageIndex,Integer length) {
        try {
            return newsDao.getNewsListByCate(cateId,pageIndex,length);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public News getNewsById(Integer id) {
        try {
            return newsDao.getById(id);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int publish(News news) {
        try {
            return newsDao.insert(news);
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public List<NewsVo> getAllNewsVo() {
        List<NewsVo> allNewsVo = new ArrayList<>();
        try {
            List<News> allNews = newsDao.getAll();
            for (News news:allNews) {
                NewsVo newsVo = new NewsVo();
                newsVo.setId(news.getId());
                newsVo.setTitle(news.getTitle());
                newsVo.setAuthor(news.getAuthor());
                newsVo.setTime(news.getTime());
                newsVo.setContent(news.getContent());
                newsVo.setCateId(news.getCateId());
                newsVo.setNewsCate(newsCateDao.getById(news.getCateId()));
                allNewsVo.add(newsVo);
            }
            return allNewsVo;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int deleteNewsById(Integer id) {
        try {
            return newsDao.deleteById(id);
        } catch (SQLException e) {
            return -1;
        }
    }
}
