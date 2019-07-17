package com.jsj.dao.Impl;

import com.jsj.dao.UserDao;
import com.jsj.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public int insert(User user) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "insert into user(username,password,birthday,email,tel_number) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        parameter(user,preparedStatement);
        int res = preparedStatement.executeUpdate();
        connection.close();
        return res;
    }

    @Override
    public int update(User user) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "update user set (username=?,password=?,birthday=?,email=?,tel_number=?) where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        parameter(user,preparedStatement);
        preparedStatement.setInt(6,user.getId());
        int res = preparedStatement.executeUpdate();
        connection.close();
        return res;
    }

    @Override
    public User getUserByPassword(String username, String password) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String loginSql = "select * from user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(loginSql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = new User();
        if (resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getNString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setEmail(resultSet.getString("email"));
            user.setTelNumber(resultSet.getString("tel_number"));
        }
        return user;
    }

    private void parameter(User user,PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setDate(3, (Date) user.getBirthday());
        preparedStatement.setString(4,user.getEmail());
        preparedStatement.setString(5,user.getTelNumber());
    }
}
