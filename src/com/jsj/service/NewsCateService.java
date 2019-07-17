package com.jsj.service;

import com.jsj.entity.CateListVm;
import com.jsj.entity.NewsCate;

import java.sql.SQLException;
import java.util.List;

public interface NewsCateService {

    List<NewsCate> getCates() throws SQLException;

    List<CateListVm> getCateListVms() throws SQLException;
}
