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

    /**
     *
     * @param cateId
     * @return 指定分类id的新闻列表
     * @throws SQLException
     */
    @Override
    public List<News> getNewsListByCate(Integer cateId) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "select * from news where cate_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,cateId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<News> newsList = new ArrayList<>();
        while (resultSet.next()){
            News news = new News();
            news.setId(resultSet.getInt("id"));
            news.setCateId(resultSet.getInt("cate_id"));
            news.setTitle(resultSet.getString("title"));
            news.setAuthor(resultSet.getString("author"));
            news.setTime(resultSet.getDate("time"));
            news.setContent(resultSet.getString("content"));
            newsList.add(news);
        }
        connection.close();
        return newsList;
    }

    @Override
    public News getById(Integer id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "select * from news where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        News news = new News();
        if (resultSet.next()){
            news.setId(resultSet.getInt("id"));
            news.setCateId(resultSet.getInt("cate_id"));
            news.setTitle(resultSet.getString("title"));
            news.setAuthor(resultSet.getString("author"));
            news.setTime(resultSet.getDate("time"));
            news.setContent(resultSet.getString("content"));
        }
        connection.close();
        return news;
    }

}
