package com.jsj.factory;

import com.jsj.service.AdminService;
import com.jsj.service.NewsCateService;
import com.jsj.service.NewsService;
import com.jsj.service.UserService;

import java.io.InputStream;
import java.util.Properties;

public class ServiceFactory {

    private ServiceFactory(){
    }

    private static Properties properties;

    static {
        InputStream inputStream = DaoFactory.class.getClassLoader().getResourceAsStream("service.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static UserService getUserService(){
        UserService userService = null;
        try {
            userService = (UserService) Class.forName(properties.getProperty("UserService")).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userService;
    }

    public static NewsCateService getNewsCateService(){
        NewsCateService newsCateService = null;
        try {
            newsCateService = (NewsCateService) Class.forName(properties.getProperty("NewsCateService")).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newsCateService;
    }

    public static NewsService getNewsService(){
        NewsService newsService = null;
        try {
            newsService = (NewsService) Class.forName(properties.getProperty("NewsService")).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newsService;
    }

    public static AdminService getAdminService(){
        AdminService adminService = null;
        try {
            adminService = (AdminService) Class.forName(properties.getProperty("AdminService")).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return adminService;
    }

}
