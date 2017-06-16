package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/15.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 添加
     */
    @RequestMapping("/saveArticle")
    public void saveArticle(Article article){
        try {
            articleService.save(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 查所有
     */
    @RequestMapping("/queryAllArticle")
    @ResponseBody
    public List<Article> queryAllArticle(){
        List<Article> articles = articleService.queryAll();
        return articles;
    }
    /**
     * 根据id查一个
     */
    @RequestMapping("/queryOneArticle")
    @ResponseBody
    public Article  queryOneArticle(String id){
        return articleService.queryById(id);
    }
    /**
     * 修改
     */
    @RequestMapping("/updateArticle")
    public void updateArticle(Article article){
        articleService.update(article);
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteArticle")
    public void delete(String id){
        articleService.delete(id);
    }
    /**
     * 分页查询
     */
    @RequestMapping("/queryArtByPage")
    @ResponseBody
    public Map queryArtByPage(Integer page, Integer rows){
        try {
            Map map = articleService.queryArticleByPage(page, rows);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
