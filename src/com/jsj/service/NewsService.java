package com.jsj.service;

import com.jsj.entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsService {

    List<News> getNewsListByCate(Integer cateId) throws SQLException;

    News getNewsById(Integer id) throws SQLException;

    int publish(News news) throws SQLException;

    List<News> getAllNews() throws SQLException;

    int deleteNewsById(Integer id) throws SQLException;
}
