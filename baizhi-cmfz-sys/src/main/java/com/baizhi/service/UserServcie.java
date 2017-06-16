package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/12.
 */
public interface UserServcie {
    /**
     * 添加
     */
    public void save(User user);
    /**
     * 查所有
     */
    public List<User> queryAll();
    /**
     * 根据id查一个
     */
    public User  queryById(String id);
    /**
     * 根据用户查询
     */
    public User queryByUser(User user);
    /**
     * 修改
     */
    public void update(User user);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 分页查询
     */
/*
    public Page<User> queryUserByPage(Integer pageNum, Integer pageSize);
*/

    /**
     * fen'yechasuoyou
     */
    public Map queryAllUserByPage(Integer page,Integer rows);
}
