package com.jsj.service;

import com.jsj.entity.News;

import java.util.List;

public interface NewsService {

    List<News> getNewsListByCate(Integer cateId);

    News getNewsById(Integer id);

    int publish(News news);

    List<News> getAllNews();

    int deleteNewsById(Integer id);
}
