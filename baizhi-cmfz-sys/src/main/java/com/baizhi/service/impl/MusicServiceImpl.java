package com.baizhi.service.impl;

import com.baizhi.dao.MusicDAO;
import com.baizhi.entity.Music;
import com.baizhi.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
@Service("musicService")
@Transactional
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicDAO musicDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Music queryById(String id) {
        return musicDAO.selectById(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Music> queryAll() {
        return musicDAO.selectAll();
    }

    public void update(Music music) {
        musicDAO.update(music);
    }

    public void delete(String id) {
        musicDAO.delete(id);
    }

    public void save(Music music) {
        musicDAO.insert(music);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryMusicByPage(Integer page, Integer rows) {
        List<Music> musics = musicDAO.queryByPage((page - 1) * rows, rows);
        Integer total = musicDAO.selectAll().size();

        Map map = new HashMap();
        map.put("rows",musics);
        map.put("total",total);

        return map;
    }
}
