package com.cqyb.music.service.impl;

import com.cqyb.music.dao.PlaylistMapper;
import com.cqyb.music.dao.ext.PlaylistExtMapper;
import com.cqyb.music.entity.Playlist;
import com.cqyb.music.entity.PlaylistExample;
import com.cqyb.music.model.PlaylistModel;
import com.cqyb.music.model.PlaylistVo;
import com.cqyb.music.service.PlaylistService;
import com.cqyb.music.util.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/24 11:00
 * @Description:
 */
@Service
public class PlaylistServiceImpl implements PlaylistService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistServiceImpl.class);
    @Autowired
    public PlaylistMapper playlistMapper;
    @Autowired
    public PlaylistExtMapper playlistExtMapper;
    @Autowired
    public RedisUtil redis;

    @Override
    public boolean saveObject(PlaylistModel playlistModel, String image) {
        if(checkRept(playlistModel.getUid(),playlistModel.getName())){
            return  false;
        }
        Playlist playlist=new Playlist();
        BeanUtils.copyProperties(playlistModel,playlist);
        playlist.setId(Utils.generateUUID());
        MultipartFile file=null;
        if(image!=null){
            file=Base64DecodeMultipartFile.base64Convert(image);
        }
        try{
            if (!file.isEmpty()||file!=null) {
                Map<String, String> map = FileUtil.uploadFile(playlist.getId(), file, Common.PLAYLIST);
                if (map.get("code") == "true") {
                    playlist.setImage(map.get("msg"));
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        int flag=playlistMapper.insertSelective(playlist);
        return flag>0?true:false;
    }

    @Override
    public boolean delete(String id) {
        int flag=0;
        if(StringUtils.isNotBlank(id)){
            flag=playlistMapper.deleteByPrimaryKey(id);
        }
        return flag>0?true:false;
    }

    @Override
    public boolean update(PlaylistModel playlistModel,String image) {
        PlaylistExample example=new PlaylistExample();
        PlaylistExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(playlistModel.getId())){
            criteria.andIdEqualTo(playlistModel.getId());
        }
        if (StringUtils.isNotBlank(playlistModel.getUid())){
            criteria.andUidEqualTo(playlistModel.getUid());
        }
        Playlist playlist=new Playlist();
        BeanUtils.copyProperties(playlistModel,playlist);
        MultipartFile file=null;
        if(image!=null){
            file=Base64DecodeMultipartFile.base64Convert(image);
        }
        try{
            if (!file.isEmpty()||file!=null) {
                Map<String, String> map = FileUtil.uploadFile(playlist.getId(), file, Common.PLAYLIST);
                if (map.get("code") == "true") {
                    playlist.setImage(map.get("msg"));
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        int flag=playlistMapper.updateByExampleSelective(playlist,example);
        return flag>0?true:false;
    }

    @Override
    public List<PlaylistVo> selectByUid(String uid) {
        List<PlaylistVo> list=playlistExtMapper.SelectByUid(uid);
        return list;
    }

    @Override
    public List<PlaylistVo> selectByExample(Integer num) {
        List<PlaylistVo> list=playlistExtMapper.SelectByExample(num);
        return list;
    }

    @Override
    public List<PlaylistVo> selectByOnLine() {
        return playlistExtMapper.SelectByOnLine();
    }

    @Override
    public List<PlaylistVo> selectById(String id) {
        return playlistExtMapper.SelectById(id);
    }

    @Override
    public List<String> selectAll() {
        return playlistExtMapper.selectAll();
    }

    @Override
    public long trafficStatistics(String id) {

        if(StringUtils.isNotBlank(id)){
            String key = Common.PLAYLIST_KEY+Common.TONGJI+id;
            long num=redis.incr(key,1);
            LOGGER.info("PlaylistServiceImpl.trafficStatistics() : 歌单统计插入缓存 >> " + num);
            return num;
        }
        return Long.parseLong(null);
    }

    public boolean checkRept(String uid,String name){
        PlaylistExample example=new PlaylistExample();
        PlaylistExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(uid)){
            criteria.andUidEqualTo(uid);
        }
        if(StringUtils.isNotBlank(name)){
            criteria.andNameEqualTo(name);
        }else {
            criteria.andNameIsNull();
        }
        int flag=playlistMapper.countByExample(example);
        return flag>0?true:false;

    }
}
