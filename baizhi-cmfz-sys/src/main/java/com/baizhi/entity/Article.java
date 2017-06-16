package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Article implements Serializable{
    private String id;
    private String title;
    private String author;
    @JSONField(format = "yyyy-MM-dd")
    private Date creatdate;
    private String content;
    private String authorpath;
    private String picpath;
    private String type;

    public Article() {
    }

    public Article(String id, String title, String author, Date creatdate, String content, String authorpath, String picpath, String type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creatdate = creatdate;
        this.content = content;
        this.authorpath = authorpath;
        this.picpath = picpath;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorpath() {
        return authorpath;
    }

    public void setAuthorpath(String authorpath) {
        this.authorpath = authorpath;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", creatdate=" + creatdate +
                ", content='" + content + '\'' +
                ", authorpath='" + authorpath + '\'' +
                ", picpath='" + picpath + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

