package com.baizhi.controller;

import com.baizhi.entity.Music;
import com.baizhi.service.MusicService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yanyan on 2017/6/14.
 */
@Controller
@RequestMapping("/music")
public class MusicController {
    @Resource
    private MusicService musicService;

    /**
     * 查一个
     */
    @RequestMapping("/queryById")
    @ResponseBody
    public Music queryById(String id){
        Music music = musicService.queryById(id);
        return music;
    }
    /**
     * 查所有
     */
    @RequestMapping("/queryAllMusic")
    @ResponseBody
    public List<Music> queryAllMusic(){
        List<Music> musics = musicService.queryAll();
        return musics;
    }
    /**
     * 修改
     */
    @RequestMapping("/updateMusic")
    public void updateMusic(Music music){
        musicService.update(music);
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void delete(String id){
        musicService.delete(id);
    }

    /**
     * 添加
     */
    @RequestMapping("/saveMusic")
    public String  saveMusic(HttpServletRequest request,MultipartFile aaa, Music music) throws Exception {
        String str = UUID.randomUUID().toString();
        String realPath = request.getSession().getServletContext().getRealPath("/back/image");
        try {
            String newFileName = UUID.randomUUID().toString() +
                    new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                    + "."
                    + FilenameUtils.getExtension(aaa.getOriginalFilename());
            music.setId(str);
            music.setPicpath(newFileName);
            aaa.transferTo(new File(realPath,newFileName));
            musicService.save(music);
            return "back/main/main";
        } catch (Exception e) {
            musicService.delete(str);
            e.printStackTrace();
            return "index";
        }

    }
    /**
     * 分页查询
     */
    @RequestMapping("/queryMusicByPage")
    @ResponseBody
    public Map queryMusicByPage(Integer page, Integer rows){
        Map map = musicService.queryMusicByPage(page, rows);
        return map;
    }

}
