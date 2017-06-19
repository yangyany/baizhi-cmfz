package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Record implements Serializable{
    private String id;
    private String name;
    private User user;
    private List<Counter> counters;

    public Record() {
    }

    public Record(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' + +
                '}';
    }
}
