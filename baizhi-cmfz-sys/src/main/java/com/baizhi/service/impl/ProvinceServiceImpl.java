package com.baizhi.service.impl;

import com.baizhi.dao.ProvinceDAO;
import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yanyan on 2017/6/14.
 */
@Service("provinceService")
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceDAO provinceDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Province queryById(String id) {
        return provinceDAO.selectById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Province> queryAll() {

        return provinceDAO.selectAll();
    }

    public void update(Province province) {
        provinceDAO.update(province);
    }

    public void delete(String id) {

        provinceDAO.delete(id);
    }

    public void save(Province province) {

        province.setId(UUID.randomUUID().toString());
        provinceDAO.insert(province);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryProvinceByPage(Integer page, Integer rows) {
        List<Province> provinces = provinceDAO.queryByPage((page - 1) * rows, rows);
        Integer total= provinceDAO.selectAll().size();
        Map map = new HashMap();
        map.put("rows",provinces);
        map.put("total",total);
        return map;
    }

   /* @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<Province> queryProByPage(Integer pageNum, Integer pageSize) {
        Page<Province> page = PageHelper.startPage(pageNum, pageSize);
        provinceDAO.selectAll();
        return page;
    }*/
}
