package com.jsj.service;

import com.jsj.entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsService {

    List<News> getNewsListByCate(Integer cateId) throws SQLException;

}
