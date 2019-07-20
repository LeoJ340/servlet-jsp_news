package com.jsj.factory;

import com.jsj.dao.AdminDao;
import com.jsj.dao.NewsCateDao;
import com.jsj.dao.NewsDao;
import com.jsj.dao.UserDao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

    // 饿汉式单例模式设计dao工厂
    private static DaoFactory daoFactory = new DaoFactory();

    private DaoFactory() {
    }

    public static DaoFactory getDaoFactory() {
        return daoFactory;
    }

    private static Properties properties = null;

    static {
        InputStream inputStream = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static UserDao getUserDao(){
        UserDao userDao = null;
        try {
            userDao = (UserDao) Class.forName(properties.getProperty("UserDao")).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userDao;
    }

    public static NewsDao getNewsDao(){
        NewsDao newsDao = null;
        try {
            newsDao = (NewsDao) Class.forName(properties.getProperty("NewsDao")).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newsDao;
    }

    public static NewsCateDao getNewsCateDao(){
        NewsCateDao newsCateDao = null;
        try {
            newsCateDao = (NewsCateDao) Class.forName(properties.getProperty("NewsCateDao")).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newsCateDao;
    }

    public static AdminDao getAdminDao(){
        AdminDao adminDao = null;
        try {
            adminDao = (AdminDao) Class.forName(properties.getProperty("AdminDao")).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return adminDao;
    }

}
