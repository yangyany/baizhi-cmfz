package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Rfc {
    private String id;
    private User user;
    private String content;
    @JSONField(format="yyyy-MM-dd")
    private Date pushdate;

    public Rfc() {
    }

    public Rfc(String id, String content, Date pushdate) {
        this.id = id;
        this.content = content;
        this.pushdate = pushdate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPushdate() {
        return pushdate;
    }

    public void setPushdate(Date pushdate) {
        this.pushdate = pushdate;
    }

    @Override
    public String toString() {
        return "Rfc{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", pushdate=" + pushdate +
                '}';
    }
}
