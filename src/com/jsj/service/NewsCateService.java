package com.jsj.service;

import com.jsj.entity.NewsCateVo;
import com.jsj.entity.NewsCate;

import java.util.List;

public interface NewsCateService {

    List<NewsCate> getAllCate();

    List<NewsCateVo> getNewsCateVoList();

    NewsCate getNewsCateById(Integer id);

    int insert(NewsCate newsCate);

    int update(NewsCate newsCate);

    int delete(Integer id);
}
