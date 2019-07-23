package com.jsj.dao;

import com.jsj.entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsDao extends BaseDao<News> {

    List<News> getNewsListByCate(Integer cateId) throws SQLException;

    int insert(News news) throws SQLException;
}
