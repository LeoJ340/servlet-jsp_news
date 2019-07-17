package com.jsj.factory;

import com.jsj.service.NewsCateService;
import com.jsj.service.UserService;

import java.io.InputStream;
import java.util.Properties;

public class ServiceFactory {

    // 饿汉式单例模式设计dao工厂
    private static ServiceFactory serviceFactory = new ServiceFactory();

    private ServiceFactory(){

    }

    public static ServiceFactory getServiceFactory(){
        return serviceFactory;
    }

    private static Properties properties = null;

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

}
