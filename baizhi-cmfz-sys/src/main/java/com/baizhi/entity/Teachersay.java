package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Teachersay implements Serializable{
    private String id;
    private User user;
    private Article article;

    public Teachersay() {
    }

    public Teachersay(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Teachersay{" +
                "id='" + id + '\'' +
                '}';
    }
}
