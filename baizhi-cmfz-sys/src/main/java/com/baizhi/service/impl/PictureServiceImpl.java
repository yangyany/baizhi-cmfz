package com.baizhi.service.impl;

import com.baizhi.cache.Cache;
import com.baizhi.dao.PictureDAO;
import com.baizhi.entity.Picture;
import com.baizhi.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/13.
 */
@Service("pictureService")
@Transactional
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDAO pictureDAO;

    public void save(Picture picture) {
        pictureDAO.insert(picture);

    }

    public void update(Picture picture) {
        pictureDAO.update(picture);

    }


    @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Picture queryById(String id) {
        return pictureDAO.selectById(id);
    }

    @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Picture> queryAll() {
        return pictureDAO.selectAll();
    }

    @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryPictureByPage(Integer page, Integer rows) {
        List<Picture> pictures = pictureDAO.queryByPage((page - 1) * rows, rows);
        Integer total = pictureDAO.selectAll().size();
        Map map = new HashMap();
        map.put("rows",pictures);
        map.put("total",total);
        return map;
    }

    public void delete(String id) {
        pictureDAO.delete(id);
    }
}
