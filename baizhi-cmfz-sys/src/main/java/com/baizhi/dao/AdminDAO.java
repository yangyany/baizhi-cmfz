package com.baizhi.dao;

import com.baizhi.entity.Admin;

/**
 * Created by yanyan on 2017/6/12.
 */
public interface AdminDAO extends BaseDAO<Admin>{
    /**
     * 根据管理员名查一个
     */
    public Admin selectOne(String useranme);
}

