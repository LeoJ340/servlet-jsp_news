package com.jsj.service.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.dao.NewsDao;
import com.jsj.entity.CateListVm;
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
    public List<NewsCate> getCates() throws SQLException {
        return newsCateDao.getAll();
    }

    @Override
    public List<CateListVm> getCateListVms() throws SQLException {
        List<CateListVm> cateListVms = new ArrayList<>();
        List<NewsCate> newsCateList = newsCateDao.getAll();
        for (NewsCate newsCate:newsCateList ) {
            CateListVm cateListVm = new CateListVm();
            cateListVm.setName(newsCate.getName());
            cateListVm.setNews(newsDao.getNewsByCate(newsCate.getName()));
            cateListVms.add(cateListVm);
        }
        return cateListVms;
    }
}
