package com.baizhi.controller;

import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Resource
    private CityService cityService;
    /**
     * 查一个
     */
    @RequestMapping("/queryOneCity")
    @ResponseBody
    public City queryOneCity(String id){
        City city = cityService.queryById(id);
        return city;
    }
    /**
     * 查所有
     */
    @RequestMapping("/queryAllCity")
    @ResponseBody
    public List<City> queryAllCity(){
        List<City> cities = cityService.queryAll();
        return cities;
    }

    /**
     * 修改
     */
    @RequestMapping("/updateCity")
    public void updateCity(City city){
        cityService.update(city);
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteCity")
    public void deleteCity(String id){
        cityService.delete(id);
    }
    /**
     * 添加
     */
    @RequestMapping("/saveCity")
    public void saveCity(City city){
        cityService.save(city);
    }
    /**
     * 分页查询
     */
    @RequestMapping("/queryCiytByPage")
    @ResponseBody
    public Map queryCiytByPage(Integer page, Integer rows){
        Map map = cityService.queryCityByPage(page, rows);
        return map;
    }
}
