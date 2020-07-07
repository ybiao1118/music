package com.cqyb.music.service.impl;

import com.cqyb.music.dao.MusicMapper;
import com.cqyb.music.dao.ext.MusicExtMapper;
import com.cqyb.music.entity.Music;
import com.cqyb.music.entity.MusicExample;
import com.cqyb.music.model.MusicModel;
import com.cqyb.music.model.SearchModel;
import com.cqyb.music.model.MusicVo;
import com.cqyb.music.service.MusicService;
import com.cqyb.music.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 16:37
 * @Description:
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    public MusicMapper musicMapper;
    @Autowired
    public MusicExtMapper musicExtMapper;
    @Autowired
    public  RedisUtil redis;

    private static final Logger LOGGER = LoggerFactory.getLogger(MusicServiceImpl.class);

    @Override
    public boolean saveOject(MusicModel musicModel, MultipartFile image, MultipartFile lyrics, MultipartFile mp3) {
        if (StringUtils.isNotBlank(musicModel.getName()) && StringUtils.isNotBlank(musicModel.getPid())) {
            if (checkRept(musicModel.getName(), musicModel.getPid())) {
                return false;
            }
            Music music = new Music();
            BeanUtils.copyProperties(musicModel, music);
            music.setId(Utils.generateUUID());
            music.setCreateTime(new Date());
            try {
                if (!image.isEmpty() || image != null) {
                    Map<String, String> map = FileUtil.uploadFile(music.getId(), image, Common.MUSIC);
                    if (map.get("code") == "true") {
                        music.setImage(map.get("msg"));
                    }else {
                        return  false;
                    }
                }
                if (!lyrics.isEmpty() || lyrics != null) {

                    Map<String, String> map = FileUtil.uploadFile(music.getId(), lyrics, Common.MUSIC);
                    if (map.get("code") == "true") {
                        music.setLyrics(map.get("msg"));
                    }else {
                        return  false;
                    }
                }
                if (!mp3.isEmpty() || mp3 != null) {

                    Map<String, String> map = FileUtil.uploadFile(music.getId(), mp3, Common.MUSIC);
                    if (map.get("code") == "true") {
                        music.setMp3(map.get("msg"));
                    }else {
                        return  false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            int flag = musicMapper.insertSelective(music);
            return flag > 0 ? true : false;
        }
        return false;
    }

    @Override
    public boolean update(MusicModel musicModel) {
        MusicExample example = new MusicExample();
        MusicExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(musicModel.getId())) {
            criteria.andIdEqualTo(musicModel.getId());
        } else {
            return false;
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicModel, music);
        int flag = musicMapper.updateByExampleSelective(music, example);
        return flag > 0 ? true : false;

    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            int flag = musicMapper.deleteByPrimaryKey(id);
            return flag > 0 ? true : false;
        }
        return false;
    }

    @Override
    public List<MusicVo> select(SearchModel searchModel) {
        if (StringUtils.isNotBlank(searchModel.getKeyWord())) {
            searchModel.setKeyWord("%" + searchModel.getKeyWord() + "%");
        }
        return musicExtMapper.selectByExample(searchModel);
    }

    @Override
    public List<MusicVo> selectOrderByNumber(Integer number) {
        if (number == null) {
            return null;
        } else {
            return musicExtMapper.selectOrderByExample(number);
        }

    }

    @Override
    public List<MusicVo> selectByCreatTime() {

        return musicExtMapper.selectByCreateTime();
    }

    @Override
    public List<String> selectAll() {
        return musicExtMapper.selectAll();
    }

    @Override
    public long trafficStatistics(String id) {
        if(StringUtils.isNotBlank(id)){

            String key = Common.MUSIC_KEY+Common.TONGJI+id;
            long num=redis.incr(key,1);
            LOGGER.info("MusicServiceImpl.trafficStatistics() : 歌曲统计插入缓存 >> " + num);
            return num;
        }
        return Long.parseLong(null);
    }

    @Override
    public PageInfo selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List<MusicVo> list = musicExtMapper.selectOrderByExample(3);
        PageInfo<MusicVo> pageInfo = new PageInfo<MusicVo>(list);
        return pageInfo;
    }


    public boolean checkRept(String name, String pid) {
        MusicExample example = new MusicExample();
        MusicExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(name)) {
            criteria.andNameEqualTo(name);
        }
        if (StringUtils.isNotBlank(pid)) {
            criteria.andPidEqualTo(pid);
        }
        int flag = musicMapper.countByExample(example);
        return flag > 0 ? true : false;
    }
}
