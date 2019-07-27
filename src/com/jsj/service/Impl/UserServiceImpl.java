package com.jsj.service.Impl;

import com.jsj.dao.UserDao;
import com.jsj.entity.User;
import com.jsj.factory.DaoFactory;
import com.jsj.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = DaoFactory.getUserDao();

    @Override
    public int register(User user) {
        try {
            return userDao.insert(user);
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            return userDao.getUserByPassword(username,password);
        } catch (SQLException e) {
            return null;
        }
    }

}
