package com.jsj.dao.Impl;

import com.jsj.dao.NewsDao;
import com.jsj.entity.News;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    /**
     *
     * @param cateId
     * @return 指定分类id的5条新闻列表
     * @throws SQLException
     */
    @Override
    public List<News> getNewsListByCate(Integer cateId) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        List<News> newsList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            String sql = "select * from news where cate_id = ? limit 0 , 5";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,cateId);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
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
                }
            }
        }
        return newsList;
    }

    @Override
    public int insert(News news) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        int res;
        try(Connection connection = dataSource.getConnection()){
            String sql = "insert into news(cate_id,title,author,time,content) values (?,?,?,?,?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,news.getCateId());
                preparedStatement.setString(2,news.getTitle());
                preparedStatement.setString(3,news.getAuthor());
                preparedStatement.setDate(4,new Date(news.getTime().getTime()));
                preparedStatement.setString(5,news.getContent());
                res = preparedStatement.executeUpdate();
            }
        }
        return res;
    }

    @Override
    public News getById(Integer id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        News news = new News();
        try(Connection connection = dataSource.getConnection()){
            String sql = "select * from news where id = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if (resultSet.next()){
                        news.setId(resultSet.getInt("id"));
                        news.setCateId(resultSet.getInt("cate_id"));
                        news.setTitle(resultSet.getString("title"));
                        news.setAuthor(resultSet.getString("author"));
                        news.setTime(resultSet.getDate("time"));
                        news.setContent(resultSet.getString("content"));
                    }
                }
            }
        }
        return news;
    }

    @Override
    public List<News> getAll() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        List<News> allNews = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            String sql = "select * from news";
            try(Statement statement = connection.createStatement();ResultSet resultSet = statement.executeQuery(sql)){
                while (resultSet.next()){
                    News news = new News();
                    news.setId(resultSet.getInt("id"));
                    news.setCateId(resultSet.getInt("cate_id"));
                    news.setTitle(resultSet.getString("title"));
                    news.setAuthor(resultSet.getString("author"));
                    news.setTime(resultSet.getDate("time"));
                    news.setContent(resultSet.getString("content"));
                    allNews.add(news);
                }
            }
        }
        return allNews;
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        int res;
        try(Connection connection = dataSource.getConnection()){
            String sql = "delete from news where id = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                res = preparedStatement.executeUpdate();
            }
        }
        return res;
    }
}
