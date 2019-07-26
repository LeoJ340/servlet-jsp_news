package com.jsj.dao.Impl;

import com.jsj.dao.UserDao;
import com.jsj.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public int insert(User user) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        int res;
        try(Connection connection = dataSource.getConnection()){
            String sql = "insert into user(username,password,birthday,email,tel_number) values (?,?,?,?,?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                parameter(user,preparedStatement);
                res = preparedStatement.executeUpdate();
            }
        }
        return res;
    }

    @Override
    public User getUserByPassword(String username, String password) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        User user = new User();
        try(Connection connection = dataSource.getConnection()){
            String sql = "select * from user where username = ? and password = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if (resultSet.next()){
                        user.setId(resultSet.getInt("id"));
                        user.setUsername(resultSet.getNString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setBirthday(resultSet.getDate("birthday"));
                        user.setEmail(resultSet.getString("email"));
                        user.setTelNumber(resultSet.getString("tel_number"));
                    }
                }
            }
        }
        return user;
    }

    private void parameter(User user,PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setDate(3, new Date(user.getBirthday().getTime()));
        preparedStatement.setString(4,user.getEmail());
        preparedStatement.setString(5,user.getTelNumber());
    }
}
