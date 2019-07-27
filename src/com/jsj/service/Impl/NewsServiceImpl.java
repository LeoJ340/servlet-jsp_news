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
    public List<News> getAllNews() {
        try {
            return newsDao.getAll();
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
