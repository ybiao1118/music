package com.cqyb.music.service.impl;

import com.alibaba.fastjson.JSON;
import com.cqyb.music.dao.PlayerMapper;
import com.cqyb.music.dao.ext.PlayerExtMapper;
import com.cqyb.music.entity.Player;
import com.cqyb.music.entity.PlayerExample;
import com.cqyb.music.entity.UserExample;
import com.cqyb.music.model.PlayerModel;
import com.cqyb.music.service.PlayerService;
import com.cqyb.music.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/23 16:41
 * @Description:
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private PlayerExtMapper playerExtMapper;
    @Autowired
    private  RedisUtil redis;

    @Override
    public boolean saveObject(PlayerModel playerModel, MultipartFile multipartFile) {
        if (checkRept(playerModel.getName())) {
            return false;
        }
        Player player = new Player();
        BeanUtils.copyProperties(playerModel, player);
        player.setId(Utils.generateUUID());
        try {
            if (!multipartFile.isEmpty()) {
                Map<String, String> map = FileUtil.uploadFile(player.getId(), multipartFile, Common.PLAYER);
                if (map.get("code") == "true") {
                    player.setImage(map.get("msg"));
                }else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int flag = playerMapper.insertSelective(player);
        return flag > 0 ? true : false;
    }

    @Override
    public boolean update(PlayerModel playerModel, MultipartFile multipartFile) {
        PlayerExample playerExample = new PlayerExample();
        PlayerExample.Criteria criteria = playerExample.createCriteria();
        if (StringUtils.isNotBlank(playerModel.getId())) {
            criteria.andIdEqualTo(playerModel.getId());
        } else {
            return false;
        }
        Player player = new Player();
        BeanUtils.copyProperties(playerModel, player);
        try {
            if (!multipartFile.isEmpty()) {
                Map<String, String> map = FileUtil.uploadFile(player.getId(), multipartFile, Common.PLAYER);
                if (map.get("code") == "true") {
                    player.setImage(map.get("msg"));
                }else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int flag = playerMapper.updateByExampleSelective(player, playerExample);
        return flag > 0 ? true : false;
    }

    @Override
    public List<Player> select(PlayerModel playerModel) {
        PlayerExample playerExample = new PlayerExample();
        PlayerExample.Criteria criteria = playerExample.createCriteria();
        if (StringUtils.isNotBlank(playerModel.getId())) {
            criteria.andIdEqualTo(playerModel.getId());
        }
        if (StringUtils.isNotBlank(playerModel.getName())) {
            String name = "%" + playerModel.getName() + "%";
            criteria.andNameLike(name);
        }
        if (StringUtils.isNotBlank(playerModel.getPinyin())) {
            criteria.andPinyinEqualTo(playerModel.getPinyin());
        }
        return playerMapper.selectByExample(playerExample);
    }

    @Override
    public boolean delete(String id) {
        int flag = 0;
        if (StringUtils.isNotBlank(id)) {
            flag = playerMapper.deleteByPrimaryKey(id);
        }
        return flag > 0 ? true : false;
    }
    //@Cacheable(value = "PLAYERHOT", key=Common.PLAYER_KEY+"HOT")
    @Override
    public List<Player> selectByHot() {
        String key=Common.PLAYER_KEY+"HOT";
        List<Player> list=new ArrayList<Player>();
        if(redis.hasKey(key)){
            List<Object> playerList=redis.lGet(key,0,-1);
            LOGGER.info("缓存中获取热门歌手==>");
//            for(int i=0;i<playerList.size();i++){
//                Player player =(Player) playerList.get(i);
//               list.add(i,player);
//            }
            for(Object obj:playerList){
                list.add((Player) obj);
            }
            return list;
        }else {
             list=playerExtMapper.selectByHot();
             for(Player player:list){
                 redis.lSet(key,player,3000);
             }
            LOGGER.info("数据库中获取热门歌手==>");
            return list;
        }
        //return playerExtMapper.selectByHot();
    }

    @Override
    public List<Player> selectByPinYinAndHot(String pinyin) {
        if(StringUtils.isNotBlank(pinyin)){
            return playerExtMapper.selectByPinYinAndHot(pinyin);
        }
        return null;
    }

    @Override
    public long trafficStatistics(String id) {

        if(StringUtils.isNotBlank(id)){

            String key = Common.PLAYER_KEY+Common.TONGJI+id;
            long num=redis.incr(key,1);
            LOGGER.info("PlayerServiceImpl.trafficStatistics() : 歌手统计插入缓存 >> " + num);
            return num;
        }
       return Long.parseLong(null);
    }

    @Override
    public List<String> selectAll() {
        return playerExtMapper.selectAll();
    }

    @Override
    public boolean updateSnumber(String id, Integer num) {

        if(StringUtils.isNotBlank(id)&&num!=null){
            Player player=new Player();
            player.setId(id);
            player.setSnumber(num);
            playerMapper.updateByPrimaryKeySelective(player);
        }
        return false;
    }

    @Override
    public PageInfo selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize,true); // 设定当前页码，以及当前页显示的条数
        PlayerExample example=new PlayerExample();
        List<Player> list = playerMapper.selectByExample(example);
        PageInfo<Player> pageInfo = new PageInfo<Player>(list);
        return pageInfo;
    }


    public boolean checkRept(String name) {
        PlayerExample example = new PlayerExample();
        PlayerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(name)) {
            criteria.andNameEqualTo(name);
        }
        int flag = playerMapper.countByExample(example);
        return flag > 0 ? true : false;
    }
}
