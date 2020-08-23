package com.jsj.dao.Impl;

import com.jsj.dao.NewsDao;
import com.jsj.entity.News;
import com.jsj.utils.BeanHandler;
import com.jsj.utils.BeanListHandler;
import com.jsj.utils.JdbcTemplate;

import java.sql.*;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    @Override
    public int getCount() throws Exception {
        String sql = "select count(*) from news";
        return JdbcTemplate.queryCount(sql);
    }

    @Override
    public int getCountByCate(Integer cateId) throws Exception {
        String sql = "select count(*) from news where cate_id = ? order by time desc";
        return JdbcTemplate.queryCount(sql, cateId);
    }

    @Override
    public List<News> getNewsList(Integer beginIndex, Integer length) throws Exception {
        String sql = "select * from news order by time desc limit ?, ?";
        return (List<News>) JdbcTemplate.query(sql,new BeanListHandler(News.class),beginIndex, length);
    }

    @Override
    public List<News> getNewsListByCate(Integer cateId,Integer beginIndex,Integer length) throws Exception {
        String sql = "select * from news where cate_id = ? limit ?, ?";
        return (List<News>) JdbcTemplate.query(sql, new BeanListHandler(News.class),cateId,beginIndex, length);
    }

    @Override
    public int insert(News news) throws Exception {
        String sql = "insert into news(cate_id,title,author,time,content) values (?,?,?,?,?)";
        return JdbcTemplate.update(sql, news.getCateId(),news.getTitle(),news.getAuthor(),
                new Date(news.getTime().getTime()),news.getContent());
    }

    @Override
    public News getById(Integer id) throws Exception {
        String sql = "select * from news where id = ?";
        return (News) JdbcTemplate.query(sql, new BeanHandler(News.class),id);
    }

    @Override
    public List<News> getAll() throws Exception {
        String sql = "select * from news";
        return (List<News>) JdbcTemplate.query(sql, new BeanListHandler(News.class));
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql = "delete from news where id = ?";
        return JdbcTemplate.update(sql, id);
    }

    @Override
    public int update(News news) throws Exception {
        String sql = "update news set title = ? , content = ? , cate_id = ? , time = ? where id = ?";
        return JdbcTemplate.update(sql,news.getTitle(),news.getContent(),news.getCateId(),news.getTime(),news.getId());
    }
}
