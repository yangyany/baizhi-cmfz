package com.baizhi.dao;

import com.baizhi.entity.Accordion;

import java.util.List;

/**
 * Created by yanyan on 2017/6/11.
 */
public interface AccordionDAO extends BaseDAO<Accordion> {
/**
 * 查询二级菜单
 */

public List<Accordion> selectList(String id);
}
