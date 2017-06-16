package com.baizhi.controller;

import com.baizhi.entity.Musicfile;
import com.baizhi.service.MusicfileService;
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
@RequestMapping("/musicfile")
public class MusicfileController {
    @Resource
    private MusicfileService musicfileService;

    /**
     * 查一个
     */
    @RequestMapping("/queryOneMusicfile")
    @ResponseBody
    public Musicfile queryOneMusicfile(String id){
        Musicfile musicfile = musicfileService.queryById(id);
        return musicfile;
    }
    /**
     * 查所有
     */
    @RequestMapping("/queryAllMusicfile")
    @ResponseBody
    public List<Musicfile> queryAllMusicfile(){
        List<Musicfile> musicfiles = musicfileService.queryAll();
        return musicfiles;
    }
    /**
     * 修改
     */
    @RequestMapping("/updateMusicfile")
    public void updateMusicfile(Musicfile musicfile){
        musicfileService.update(musicfile);
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteMusicfile")
    public void deleteMusicfile(String id){
        musicfileService.delete(id);
    }
    /**
     * 添加
     */
    @RequestMapping("/saveMusicfile")
    public void saveMusicfile(Musicfile musicfile){

        musicfileService.save(musicfile);
    }
    /**
     * 分页查询
     */
    @RequestMapping("/queryMusByPage")
    @ResponseBody
    public Map queryMusByPage(Integer page, Integer rows){
        Map map = musicfileService.queryMusicByPage(page, rows);
        return map;
    }

}
