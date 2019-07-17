package com.jsj.entity;

import java.util.List;

public class CateListVm {

    private String name;

    private List<News> news;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "CateListVm{" +
                "name='" + name + '\'' +
                ", news=" + news +
                '}';
    }
}
