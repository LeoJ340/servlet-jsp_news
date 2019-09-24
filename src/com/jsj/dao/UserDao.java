package com.jsj.dao;

import com.jsj.entity.User;

public interface UserDao extends BaseDao<User> {

    User getUserByPassword(String username,String password) throws Exception;
}
