package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Musicfile implements Serializable{
    private String id;
    private String title;
    private String name;
    private Integer size;

    private Music music;

    public Musicfile() {
    }

    public Musicfile(String id, String title, String name, Integer size) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.size = size;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @Override
    public String toString() {
        return "Musicfile{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
