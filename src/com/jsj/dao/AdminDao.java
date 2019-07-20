package com.jsj.dao;

import com.jsj.entity.Admin;

import java.sql.SQLException;

public interface AdminDao {

    Admin getAdminByPassword(String username,String password) throws SQLException;
}
