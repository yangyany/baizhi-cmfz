package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface ArticleDAO extends BaseDAO<Article> {
    /**
     * 分页查询
     */
    public List<Article> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

}
