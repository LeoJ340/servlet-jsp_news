package com.jsj.service;

import com.jsj.entity.News;
import com.jsj.entity.NewsVo;
import com.jsj.entity.Page;

import java.util.List;

public interface NewsService {

    Page<NewsVo> getNewsVoPage(Integer pageIndex, Integer pageSize);

    Page<News> getNewsPageByCate(Integer cateId,Integer pageIndex, Integer pageSize);

    List<NewsVo> getNewsVoList(Integer pageIndex,Integer length);

    List<News> getNewsListByCate(Integer cateId,Integer pageIndex,Integer length);

    News getNewsById(Integer id);

    int publish(News news);

    List<NewsVo> getAllNewsVo();

    int deleteNewsById(Integer id);
}
