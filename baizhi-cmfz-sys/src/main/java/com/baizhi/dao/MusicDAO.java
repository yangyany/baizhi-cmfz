package com.baizhi.dao;

import com.baizhi.entity.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface MusicDAO extends BaseDAO<Music> {
    /**
     * 分页查询
     */
    public List<Music> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

}
