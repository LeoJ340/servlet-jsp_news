package com.jsj.service;

import com.jsj.entity.User;

import java.sql.SQLException;

public interface UserService{

    boolean register(User user) throws SQLException;

    User login(String username,String password) throws SQLException;
}
