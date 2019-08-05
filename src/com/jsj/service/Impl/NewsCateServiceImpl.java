package com.jsj.service.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.dao.NewsDao;
import com.jsj.entity.NewsCateVo;
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
    public List<NewsCate> getAllCate() {
        try {
            return newsCateDao.getAll();
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<NewsCateVo> getNewsCateVoList() {
        try {
            List<NewsCateVo> newsCateVoList = new ArrayList<>();
            List<NewsCate> newsAllCate = newsCateDao.getAll();
            for (NewsCate newsCate:newsAllCate ) {
                NewsCateVo newsCateVo = new NewsCateVo();
                newsCateVo.setCateId(newsCate.getId());
                newsCateVo.setName(newsCate.getName());
                newsCateVo.setNews(newsDao.getNewsListByCate(newsCate.getId()));
                newsCateVoList.add(newsCateVo);
            }
            return newsCateVoList;
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public NewsCate getNewsCateById(Integer id) {
        try {
            return newsCateDao.getById(id);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int insert(NewsCate newsCate) {
        try {
            return newsCateDao.insert(newsCate);
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public int update(NewsCate newsCate) {
        try {
            return newsCateDao.update(newsCate);
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public int delete(Integer id) {
        try {
            return newsCateDao.deleteById(id);
        } catch (SQLException e) {
            return -1;
        }
    }
}
