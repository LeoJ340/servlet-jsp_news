package com.jsj.service.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.dao.NewsDao;
import com.jsj.entity.NewsVm;
import com.jsj.entity.NewsCate;
import com.jsj.factory.DaoFactory;
import com.jsj.service.NewsCateService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsCateServiceImpl implements NewsCateService {

    private NewsCateDao newsCateDao = DaoFactory.getNewsCateDao();

    private NewsDao newsDao = DaoFactory.getNewsDao();

    @Override
    public List<NewsCate> getAllCate() throws SQLException {
        return newsCateDao.getAll();
    }

    @Override
    public List<NewsVm> getNewsVmList() throws SQLException {
        List<NewsVm> newsVmList = new ArrayList<>();
        List<NewsCate> newsAllCate = newsCateDao.getAll();
        for (NewsCate newsCate:newsAllCate ) {
            NewsVm newsVm = new NewsVm();
            newsVm.setCateId(newsCate.getId());
            newsVm.setName(newsCate.getName());
            newsVm.setNews(newsDao.getNewsListByCate(newsCate.getId()));
            newsVmList.add(newsVm);
        }
        return newsVmList;
    }

    @Override
    public NewsCate getNewsCateById(Integer id) throws SQLException {
        return newsCateDao.getById(id);
    }

    @Override
    public int insert(NewsCate newsCate) throws SQLException {
        return newsCateDao.insert(newsCate);
    }

    @Override
    public int update(NewsCate newsCate) throws SQLException {
        return newsCateDao.update(newsCate);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return newsCateDao.deleteById(id);
    }
}
