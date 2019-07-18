package com.jsj.service;

import com.jsj.entity.NewsVm;
import com.jsj.entity.NewsCate;

import java.sql.SQLException;
import java.util.List;

public interface NewsCateService {

    List<NewsCate> getAllCate() throws SQLException;

    List<NewsVm> getNewsVmList() throws SQLException;

    NewsCate getNewsCateById(Integer id) throws SQLException;
}
