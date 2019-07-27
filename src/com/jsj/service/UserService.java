package com.jsj.service;

import com.jsj.entity.User;

public interface UserService{

    int register(User user);

    User login(String username,String password);
}
