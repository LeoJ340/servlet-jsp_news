package com.jsj.service;

import com.jsj.entity.News;
import com.jsj.entity.NewsVo;

import java.util.List;

public interface NewsService {

    List<News> getNewsListByCate(Integer cateId);

    News getNewsById(Integer id);

    int publish(News news);

    List<NewsVo> getAllNewsVo();

    int deleteNewsById(Integer id);
}
