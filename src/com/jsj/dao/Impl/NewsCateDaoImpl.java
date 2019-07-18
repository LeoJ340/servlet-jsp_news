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
        Connection connection = dataSource.getConnection();
        String sql = "select * from news_cate";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<NewsCate> newsCateList = new ArrayList<>();
        while (resultSet.next()){
            NewsCate newsCate = new NewsCate();
            newsCate.setId(resultSet.getInt("id"));
            newsCate.setName(resultSet.getString("name"));
            newsCateList.add(newsCate);
        }
        connection.close();
        return newsCateList;
    }

    @Override
    public NewsCate getById(Integer id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "select * from news_cate where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        NewsCate newsCate = new NewsCate();
        if (resultSet.next()){
            newsCate.setId(resultSet.getInt("id"));
            newsCate.setName(resultSet.getString("name"));
        }
        connection.close();
        return newsCate;
    }
}
