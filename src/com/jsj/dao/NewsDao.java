package com.jsj.dao;

import com.jsj.entity.News;

import java.util.List;

public interface NewsDao extends BaseDao<News> {

    int getCount() throws Exception;

    int getCountByCate(Integer cateId) throws Exception;

    List<News> getNewsList(Integer beginIndex, Integer length) throws Exception;

    List<News> getNewsListByCate(Integer cateId,Integer beginIndex,Integer length) throws Exception;

    int insert(News news) throws Exception;
}
