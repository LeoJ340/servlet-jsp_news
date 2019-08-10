package com.jsj.dao.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.entity.NewsCate;
import com.jsj.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsCateDaoImpl implements NewsCateDao {

    @Override
    public List<NewsCate> getAll() throws SQLException {
        List<NewsCate> newsCateList = new ArrayList<>();
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from news_cate";
        try (Statement statement = connection.createStatement();ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                NewsCate newsCate = new NewsCate();
                newsCate.setId(resultSet.getInt("id"));
                newsCate.setName(resultSet.getString("name"));
                newsCateList.add(newsCate);
            }
        }
        JdbcUtils.releaseConnection(connection);
        return newsCateList;
    }

    @Override
    public NewsCate getById(Integer id) throws SQLException {
        NewsCate newsCate = new NewsCate();
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from news_cate where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    newsCate.setId(resultSet.getInt("id"));
                    newsCate.setName(resultSet.getString("name"));
                }
            }
        }
        JdbcUtils.releaseConnection(connection);
        return newsCate;
    }

    @Override
    public int insert(NewsCate newsCate) throws SQLException {
        int res;
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into news_cate(name) values (?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,newsCate.getName());
            res = preparedStatement.executeUpdate();
        }
        JdbcUtils.releaseConnection(connection);
        return res;
    }

    @Override
    public int update(NewsCate newsCate) throws SQLException {
        int res;
        Connection connection = JdbcUtils.getConnection();
        String sql = "update news_cate set name=? where id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,newsCate.getName());
            preparedStatement.setInt(2,newsCate.getId());
            res = preparedStatement.executeUpdate();
        }
        JdbcUtils.releaseConnection(connection);
        return res;
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        int res;
        Connection connection = JdbcUtils.getConnection();
        String sql = "delete from news_cate where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            res = preparedStatement.executeUpdate();
        }
        JdbcUtils.releaseConnection(connection);
        return res;
    }
}
