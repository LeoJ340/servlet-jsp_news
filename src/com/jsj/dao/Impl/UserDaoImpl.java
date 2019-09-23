package com.jsj.dao.Impl;

import com.jsj.dao.UserDao;
import com.jsj.entity.User;
import com.jsj.utils.JdbcUtils;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public int insert(User user) throws SQLException {
        int res;
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into user(username,password,birthday,email,tel_number) values (?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            parameter(user,preparedStatement);
            res = preparedStatement.executeUpdate();
        }
        JdbcUtils.releaseConnection(connection);
        return res;
    }

    @Override
    public User getUserByPassword(String username, String password) throws SQLException {
        User user = new User();
        Connection connection = JdbcUtils.getConnection();
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
        JdbcUtils.releaseConnection(connection);
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
