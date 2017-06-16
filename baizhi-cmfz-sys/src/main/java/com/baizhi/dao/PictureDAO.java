package com.baizhi.dao;

import com.baizhi.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/13.
 */
public interface PictureDAO extends BaseDAO<Picture>{
    /**
     * 分页查询
     */
    public List<Picture> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

}
