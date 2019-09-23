package com.jsj.dao;

import com.jsj.entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsDao extends BaseDao<News> {

    int getCount() throws SQLException;

    int getCountByCate(Integer cateId) throws SQLException;

    List<News> getNewsList(Integer beginIndex, Integer length) throws SQLException;

    List<News> getNewsListByCate(Integer cateId,Integer beginIndex,Integer length) throws SQLException;

    int insert(News news) throws SQLException;
}
