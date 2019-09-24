package com.jsj.dao.Impl;

import com.jsj.dao.AdminDao;
import com.jsj.entity.Admin;
import com.jsj.utils.BeanHandler;
import com.jsj.utils.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin getAdminByPassword(String username, String password) throws Exception {
        String sql = "select * from admin where username = ? and password = ?";
        return (Admin) JdbcTemplate.query(sql, new BeanHandler(Admin.class), username, password);
    }
}
