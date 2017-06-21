package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Music implements Serializable{
    private String id;
    private String title;
    private Integer count;
    private String author;
    private String broadcast;
    private String picpath;

    private List<Musicfile> musicfiles;

    public Music() {
    }

    public Music(String id, String title, Integer count, String author, String broadcast, String picpath) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.author = author;
        this.broadcast = broadcast;
        this.picpath = picpath;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public List<Musicfile> getMusicfiles() {
        return musicfiles;
    }

    public void setMusicfiles(List<Musicfile> musicfiles) {
        this.musicfiles = musicfiles;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", picpath='" + picpath + '\'' +
                '}';
    }
}
