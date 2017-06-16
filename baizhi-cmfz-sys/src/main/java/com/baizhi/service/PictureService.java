package com.baizhi.service;

import com.baizhi.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/13.
 */
public interface PictureService {
    /**
     * 添加
     */
    public void save(Picture picture);
    /**
     * 修改
     */
    public void update(Picture picture);
    /**
     * 查一个
     */
    public Picture queryById(String id);
    /**
     * 查所有
     */
    public List<Picture> queryAll();
    /**
     * 分页查所有
     */
    public Map queryPictureByPage(Integer page, Integer rows);
    /**
     * 删除
     */
    public void delete(String id);
}
