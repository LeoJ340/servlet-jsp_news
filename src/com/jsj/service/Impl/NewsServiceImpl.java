package com.jsj.service.Impl;

import com.jsj.dao.NewsDao;
import com.jsj.entity.News;
import com.jsj.factory.DaoFactory;
import com.jsj.service.NewsService;

import java.sql.SQLException;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao = DaoFactory.getNewsDao();

    @Override
    public List<News> getNewsListByCate(Integer cateId) throws SQLException {
        return newsDao.getNewsListByCate(cateId);
    }

    @Override
    public News getNewsById(Integer id) throws SQLException {
        return newsDao.getById(id);
    }

    @Override
    public int publish(News news) throws SQLException {
        return newsDao.insert(news);
    }
}
