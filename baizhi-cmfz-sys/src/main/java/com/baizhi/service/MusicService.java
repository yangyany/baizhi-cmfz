package com.baizhi.service;

import com.baizhi.entity.Music;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface MusicService {

    /**
     * 查一个
     */
    public Music queryById(String id);
    /**
     * 查所有
     */
    public List<Music> queryAll();
    /**
     * 修改
     */
    public void update(Music music);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 添加
     */
    public void save(Music music);
    /**
     * 分页查询
     */
    public Map queryMusicByPage(Integer page, Integer rows);
}
