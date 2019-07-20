package com.jsj.service;

import com.jsj.entity.Admin;

import java.sql.SQLException;

public interface AdminService {

    Admin login(String username,String password) throws SQLException;
}
