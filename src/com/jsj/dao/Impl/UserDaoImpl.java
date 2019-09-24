package com.jsj.dao.Impl;

import com.jsj.dao.UserDao;
import com.jsj.entity.User;
import com.jsj.utils.BeanHandler;
import com.jsj.utils.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    @Override
    public int insert(User user) throws Exception {
        String sql = "insert into user(username,password,birthday,email,tel_number) values (?,?,?,?,?)";
        return JdbcTemplate.update(sql, user.getUsername(),user.getPassword(),user.getBirthday(),user.getEmail(),user.getTelNumber());
    }

    @Override
    public User getUserByPassword(String username, String password) throws Exception {
        String sql = "select * from user where username = ? and password = ?";
        return (User) JdbcTemplate.query(sql,new BeanHandler(User.class),username, password);
    }

}
