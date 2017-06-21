package com.baizhi.service.impl;

import com.baizhi.cache.Cache;
import com.baizhi.dao.CityDAO;
import com.baizhi.entity.City;
import com.baizhi.service.CityService;
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
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;

   @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public City queryById(String id) {
        return cityDAO.selectById(id);
    }

   @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<City> queryAll() {

        return cityDAO.selectAll();
    }

    public void update(City city) {
            cityDAO.update(city);
    }

    public void delete(String id) {

        cityDAO.delete(id);
    }

    public void save(City city) {

        city.setId(UUID.randomUUID().toString());
        cityDAO.insert(city);
    }

    @Cache
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryCityByPage(Integer page, Integer rows) {
        List<City> cities = cityDAO.queryByPage((page - 1) * rows, rows);
        Integer total = cityDAO.selectAll().size();
        Map map = new HashMap();
        map.put("rows",cities);
        map.put("total",total);
        return map;
    }
}
