package com.jsj.dao.Impl;

import com.jsj.dao.NewsDao;
import com.jsj.entity.News;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    @Override
    public List<News> getNewsByCate(String cateName) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "select * from news where cate = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,cateName);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<News> newsList = new ArrayList<>();
        while (resultSet.next()){
            News news = new News();
            news.setId(resultSet.getInt("id"));
            news.setTitle(resultSet.getString("title"));
            news.setAuthor(resultSet.getString("author"));
            news.setTime(resultSet.getDate("time"));
            news.setContent(resultSet.getString("content"));
            news.setCate(resultSet.getString("cate"));
            newsList.add(news);
        }
        return newsList;
    }
}
