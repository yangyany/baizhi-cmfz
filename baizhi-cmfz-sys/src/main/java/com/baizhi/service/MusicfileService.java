package com.baizhi.service;

import com.baizhi.entity.Musicfile;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface MusicfileService {
    /**
     * 查一个
     */
    public Musicfile queryById(String id);
    /**
     * 查所有
     */
    public List<Musicfile> queryAll();
    /**
     * 修改
     */
    public void update(Musicfile musicfile);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 添加
     */
    public void save(Musicfile musicfile);
    /**
     * 分页查询
     */
    public Map queryMusicByPage(Integer page, Integer rows);
}
