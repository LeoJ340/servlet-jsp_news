package com.jsj.service.Impl;

import com.jsj.dao.AdminDao;
import com.jsj.entity.Admin;
import com.jsj.factory.DaoFactory;
import com.jsj.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = (AdminDao) DaoFactory.getDao("AdminDao");

    @Override
    public Admin login(String username, String password) {
        try {
            return adminDao.getAdminByPassword(username, password);
        } catch (Exception e) {
            return null;
        }
    }
}
