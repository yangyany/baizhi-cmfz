package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Counter implements Serializable{
    private String id;
    private String name;
    @JSONField(format = "yyyy-MM-dd")
    private Date creatdate;
    private Integer count;
    private Record record;

    public Counter() {
    }

    public Counter(String id, String name, Date creatdate, Integer count) {
        this.id = id;
        this.name = name;
        this.creatdate = creatdate;
        this.count = count;
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

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creatdate=" + creatdate +
                ", count=" + count +
                '}';
    }
}
