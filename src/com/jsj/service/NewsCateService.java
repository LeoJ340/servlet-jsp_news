package com.jsj.service;

import com.jsj.entity.NewsVm;
import com.jsj.entity.NewsCate;

import java.util.List;

public interface NewsCateService {

    List<NewsCate> getAllCate();

    List<NewsVm> getNewsVmList();

    NewsCate getNewsCateById(Integer id);

    int insert(NewsCate newsCate);

    int update(NewsCate newsCate);

    int delete(Integer id);
}
