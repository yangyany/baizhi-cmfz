package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by yanyan on 2017/6/12.
 */
public interface AdminService {
    /**
     * 添加
     */
    public void save(Admin admin);
    /**
     * 根据官员名称查一个
     */
    public Admin queryOne(Admin admin);
}
