package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface ArticleService {
    /**
     * 添加
     */
    public void save(Article article);
    /**
     * 查所有
     */
    public List<Article> queryAll();
    /**
     * 根据id查一个
     */
    public Article  queryById(String id);
    /**
     * 修改
     */
    public void update(Article article);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 分页查询
     */
    public Map queryArticleByPage(Integer page, Integer rows);
}
