package com.jsj.dao;

import com.jsj.entity.User;

import java.sql.SQLException;

public interface UserDao extends BaseDao<User> {

    User getUserByPassword(String username,String password) throws SQLException;
}
