package com.baizhi.dao;

import com.baizhi.entity.Musicfile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface MusicfileDAO extends BaseDAO<Musicfile> {
    /**
     * 分页查询
     */
    public List<Musicfile> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

}
