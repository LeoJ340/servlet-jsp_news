package com.jsj.dao.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.entity.NewsCate;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsCateDaoImpl implements NewsCateDao {

    @Override
    public List<NewsCate> getAll() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        List<NewsCate> newsCateList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            String sql = "select * from news_cate";
            try (Statement statement = connection.createStatement();ResultSet resultSet = statement.executeQuery(sql)){
                while (resultSet.next()){
                    NewsCate newsCate = new NewsCate();
                    newsCate.setId(resultSet.getInt("id"));
                    newsCate.setName(resultSet.getString("name"));
                    newsCateList.add(newsCate);
                }
            }
        }
        return newsCateList;
    }

    @Override
    public NewsCate getById(Integer id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        NewsCate newsCate = new NewsCate();
        try(Connection connection = dataSource.getConnection()){
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
        }
        return newsCate;
    }

    @Override
    public int insert(NewsCate newsCate) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        int res;
        try(Connection connection = dataSource.getConnection()){
            String sql = "insert into news_cate(name) values (?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,newsCate.getName());
                res = preparedStatement.executeUpdate();
            }
        }
        return res;
    }

    @Override
    public int update(NewsCate newsCate) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        int res;
        try(Connection connection = dataSource.getConnection()){
            String sql = "update news_cate set name=? where id=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,newsCate.getName());
                preparedStatement.setInt(2,newsCate.getId());
                res = preparedStatement.executeUpdate();
            }
        }
        return res;
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        int res;
        try(Connection connection = dataSource.getConnection()){
            String sql = "delete from news_cate where id = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                res = preparedStatement.executeUpdate();
            }
        }
        return res;
    }
}
