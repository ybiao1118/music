package com.cqyb.music.service.impl;

import com.cqyb.music.dao.PlaylistCenterMapper;
import com.cqyb.music.dao.ext.MusicExtMapper;
import com.cqyb.music.entity.PlaylistCenter;
import com.cqyb.music.entity.PlaylistCenterExample;
import com.cqyb.music.model.MusicVo;
import com.cqyb.music.service.PlaylistCenterService;
import com.cqyb.music.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 15:14
 * @Description:
 */
@Service
public class PlaylistCenterServiceImpl implements PlaylistCenterService {
    @Autowired
    public PlaylistCenterMapper playlistCenterMapper;
    @Autowired
    public MusicExtMapper musicExtMapper;
    @Override
    public boolean saveObject(PlaylistCenter playlistCenter) {
        if(StringUtils.isNotBlank(playlistCenter.getMid())&&StringUtils.isNotBlank(playlistCenter.getPlid())){
            if(checkRept(playlistCenter)){
                return  false;
            }else{
                playlistCenter.setId(Utils.generateUUID());
                int flag=playlistCenterMapper.insertSelective(playlistCenter);
                return  flag>0?true:false;
            }
        }
        return false;
    }

    @Override
    public boolean delete(PlaylistCenter playlistCenter) {
        if(StringUtils.isNotBlank(playlistCenter.getMid())&&StringUtils.isNotBlank(playlistCenter.getPlid())){
            PlaylistCenterExample example=new PlaylistCenterExample();
            PlaylistCenterExample.Criteria criteria=example.createCriteria();
            criteria.andMidEqualTo(playlistCenter.getMid());
            criteria.andPlidEqualTo(playlistCenter.getPlid());
            int flag=playlistCenterMapper.deleteByExample(example);
            return flag>0?true:false;
        }

        return false;
    }

    @Override
    public List<MusicVo> select(String plid) {
        if(StringUtils.isNotBlank(plid)){
            return musicExtMapper.selectByPlid(plid);
        }else {
            return null;
        }
    }
    public boolean checkRept(PlaylistCenter playlistCenter){
        if(StringUtils.isNotBlank(playlistCenter.getMid())&&StringUtils.isNotBlank(playlistCenter.getPlid())){
            PlaylistCenterExample example=new PlaylistCenterExample();
            PlaylistCenterExample.Criteria criteria=example.createCriteria();
            criteria.andPlidEqualTo(playlistCenter.getPlid());
            criteria.andMidEqualTo(playlistCenter.getMid());
            int flag=playlistCenterMapper.countByExample(example);
            return  flag>0?true:false;
        }
        return  false;
    }
}
