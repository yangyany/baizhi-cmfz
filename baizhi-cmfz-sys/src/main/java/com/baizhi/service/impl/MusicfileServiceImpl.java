package com.baizhi.service.impl;

import com.baizhi.dao.MusicfileDAO;
import com.baizhi.entity.Musicfile;
import com.baizhi.service.MusicfileService;
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
@Service("musicfileService")
@Transactional
public class MusicfileServiceImpl implements MusicfileService {
    @Autowired
    private MusicfileDAO musicfileDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Musicfile queryById(String id) {
        return musicfileDAO.selectById(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Musicfile> queryAll() {

        return musicfileDAO.selectAll();
    }

    public void update(Musicfile musicfile) {
        musicfileDAO.update(musicfile);
    }

    public void delete(String id) {
        musicfileDAO.delete(id);
    }

    public void save(Musicfile musicfile) {
        musicfile.setId(UUID.randomUUID().toString());
        musicfile.setSize(45);
        musicfileDAO.insert(musicfile);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryMusicByPage(Integer page, Integer rows) {
        List<Musicfile> musicfiles = musicfileDAO.queryByPage((page - 1) * rows, rows);
        Integer total = musicfileDAO.selectAll().size();

        Map map = new HashMap();
        map.put("rows",musicfiles);
        map.put("total",total);
        return map;
    }
}
