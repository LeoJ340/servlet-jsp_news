package com.jsj.dao.Impl;

import com.jsj.dao.AdminDao;
import com.jsj.entity.Admin;
import com.jsj.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin getAdminByPassword(String username, String password) throws SQLException {
        Admin admin = new Admin();
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from admin where username = ? and password = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    admin.setId(resultSet.getInt("id"));
                    admin.setUsername(resultSet.getString("username"));
                }
            }
        }
        JdbcUtils.releaseConnection(connection);
        return admin;
    }
}
