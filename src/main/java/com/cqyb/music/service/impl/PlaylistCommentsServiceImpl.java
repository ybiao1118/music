package com.cqyb.music.service.impl;

import com.cqyb.music.dao.PlaylistCommentsMapper;
import com.cqyb.music.dao.ext.CommentsExtMapper;
import com.cqyb.music.entity.PlaylistComments;
import com.cqyb.music.entity.PlaylistCommentsExample;
import com.cqyb.music.model.CommentsVo;
import com.cqyb.music.model.PlaylistCommentsModel;
import com.cqyb.music.service.PlaylistCommentsService;
import com.cqyb.music.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/24 17:20
 * @Description:
 */
@Service
public class PlaylistCommentsServiceImpl implements PlaylistCommentsService {
    @Autowired
    public PlaylistCommentsMapper playlistCommentsMapper;
    @Autowired
    public CommentsExtMapper commentsExtMapper;
    @Override
    public boolean saveObject(PlaylistCommentsModel playlistCommentsModel) {
        PlaylistComments playlistComments=new PlaylistComments();
        BeanUtils.copyProperties(playlistCommentsModel,playlistComments);
        playlistComments.setId(Utils.generateUUID());
        playlistComments.setTime(new Date());
        int flag=playlistCommentsMapper.insertSelective(playlistComments);
        return flag>0?true:false;
    }

    @Override
    public boolean delete(String id) {
        if(StringUtils.isNotBlank(id)){
           int flag=playlistCommentsMapper.deleteByPrimaryKey(id);
           return  flag>0?true:false;
        }
        return false;
    }

    @Override
    public boolean update(String id, int znumber) {
        PlaylistCommentsExample example=new PlaylistCommentsExample();
        PlaylistCommentsExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(id)){
            criteria.andIdEqualTo(id);
        }
        PlaylistComments playlistComments=new PlaylistComments();
        playlistComments.setZnumber(znumber);
        int flag=playlistCommentsMapper.updateByExampleSelective(playlistComments,example);
        return flag>0?true:false;
    }

    @Override
    public List<CommentsVo> select(String plid) {

        if(StringUtils.isNotBlank(plid)){
          return commentsExtMapper.selectByPlayList(plid);
        }
        return null;
    }

    @Override
    public Integer getCount(String plid) {
        PlaylistCommentsExample example=new PlaylistCommentsExample();
        PlaylistCommentsExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(plid)){
            criteria.andPlidEqualTo(plid);
            return playlistCommentsMapper.countByExample(example);
        }
        return null;
    }
}
