package com.jsj.dao.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.dao.NewsDao;
import com.jsj.entity.News;
import com.jsj.entity.NewsCate;
import com.jsj.factory.DaoFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    private NewsCateDao newsCateDao = DaoFactory.getNewsCateDao();

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
        String sql = "select * from news where cate_id = ? limit 0 , 5";
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
    public int insert(News news) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "insert into news(cate_id,title,author,time,content) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,news.getCateId());
        preparedStatement.setString(2,news.getTitle());
        preparedStatement.setString(3,news.getAuthor());
        preparedStatement.setDate(4,new Date(news.getTime().getTime()));
        preparedStatement.setString(5,news.getContent());
        int res = preparedStatement.executeUpdate();
        connection.close();
        return res;
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

    @Override
    public List<News> getAll() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "select * from news";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<News> allNews = new ArrayList<>();
        while (resultSet.next()){
            News news = new News();
            news.setId(resultSet.getInt("id"));
            NewsCate newsCate = newsCateDao.getById(resultSet.getInt("cate_id"));
            news.setCate(newsCate.getName());
            news.setTitle(resultSet.getString("title"));
            news.setAuthor(resultSet.getString("author"));
            news.setTime(resultSet.getDate("time"));
            news.setContent(resultSet.getString("content"));
            allNews.add(news);
        }
        connection.close();
        return allNews;
    }
}
