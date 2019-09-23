package com.jsj.factory;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

    private DaoFactory() {
    }

    private static Properties properties;

    static {
        InputStream inputStream = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static Object getDao(String daoName){
        try {
            return Class.forName(properties.getProperty(daoName)).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    }

}
