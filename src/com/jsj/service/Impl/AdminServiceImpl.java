package com.jsj.service.Impl;

import com.jsj.dao.AdminDao;
import com.jsj.entity.Admin;
import com.jsj.factory.DaoFactory;
import com.jsj.service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = DaoFactory.getAdminDao();

    @Override
    public Admin login(String username, String password) throws SQLException {
        return adminDao.getAdminByPassword(username, password);
    }
}
