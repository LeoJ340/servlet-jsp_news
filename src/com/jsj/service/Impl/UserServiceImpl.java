package com.jsj.service.Impl;

import com.jsj.dao.UserDao;
import com.jsj.entity.User;
import com.jsj.factory.DaoFactory;
import com.jsj.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = DaoFactory.getUserDao();

    @Override
    public boolean register(User user) throws SQLException {
        int res = userDao.insert(user);
        return res > 0;
    }

    @Override
    public User login(String username, String password) throws SQLException {
        return userDao.getUserByPassword(username,password);
    }

}
