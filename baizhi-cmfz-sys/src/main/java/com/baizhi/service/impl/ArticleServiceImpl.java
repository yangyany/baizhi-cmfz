package com.baizhi.service.impl;

import com.baizhi.cache.Cache;
import com.baizhi.dao.ArticleDAO;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by yanyan on 2017/6/14.
 */
@Service("/articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    public void save(Article article) {
        article.setId(UUID.randomUUID().toString());
        article.setCreatdate(new Date());
        articleDAO.insert(article);
    }

    @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Article> queryAll() {
        List<Article> articles = articleDAO.selectAll();
        return articles;
    }
    @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Article queryById(String id) {
        Article article = articleDAO.selectById(id);
        return article;
    }

    public void update(Article article) {
        articleDAO.update(article);
    }

    public void delete(String id) {
        articleDAO.delete(id);
    }

    @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryArticleByPage(Integer page, Integer rows) {
        List<Article> articles = articleDAO.queryByPage((page - 1) * rows, rows);
        Integer total = articleDAO.selectAll().size();

        Map map = new HashMap();
        map.put("rows",articles);
        map.put("total",total);
        return map;
    }
}
