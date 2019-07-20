package com.jsj.dao.Impl;

import com.jsj.dao.AdminDao;
import com.jsj.entity.Admin;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin getAdminByPassword(String username, String password) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "select * from admin where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        Admin admin = new Admin();
        if (resultSet.next()){
            admin.setId(resultSet.getInt("id"));
            admin.setUsername(resultSet.getString("username"));
        }
        connection.close();
        return admin;
    }
}
