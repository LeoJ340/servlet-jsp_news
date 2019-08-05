package com.jsj.service.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.dao.NewsDao;
import com.jsj.entity.News;
import com.jsj.entity.NewsVo;
import com.jsj.factory.DaoFactory;
import com.jsj.service.NewsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao = DaoFactory.getNewsDao();

    private NewsCateDao newsCateDao = DaoFactory.getNewsCateDao();

    @Override
    public List<News> getNewsListByCate(Integer cateId) {
        try {
            return newsDao.getNewsListByCate(cateId);
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
