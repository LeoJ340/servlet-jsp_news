package com.jsj.dao;

import com.jsj.entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsDao extends BaseDao<News> {

    List<News> getNewsByCate(String cateName) throws SQLException;
}
