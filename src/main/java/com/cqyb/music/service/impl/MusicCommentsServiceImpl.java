package com.cqyb.music.service.impl;

import com.cqyb.music.dao.MusicCommentsMapper;
import com.cqyb.music.dao.ext.CommentsExtMapper;
import com.cqyb.music.entity.MusicComments;
import com.cqyb.music.entity.MusicCommentsExample;
import com.cqyb.music.model.CommentsVo;
import com.cqyb.music.model.MusicCommentsModel;
import com.cqyb.music.service.MusicCommentsService;
import com.cqyb.music.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 14:41
 * @Description:
 */
@Service
public class MusicCommentsServiceImpl implements MusicCommentsService {
    @Autowired
    public MusicCommentsMapper mapper;
    @Autowired
    public CommentsExtMapper commentsExtMapper;
    @Override
    public boolean saveObject(MusicCommentsModel musicCommentsModel) {
        MusicComments musicComments = new MusicComments();
        BeanUtils.copyProperties(musicCommentsModel, musicComments);
        musicComments.setId(Utils.generateUUID());
        musicComments.setTime(new Date());
        int flag = mapper.insertSelective(musicComments);
        return flag > 0 ? true : false;
    }

    @Override
    public boolean update(String id, Integer znumber) {
        MusicComments musicComments = new MusicComments();
        musicComments.setZnumber(znumber);
        musicComments.setId(id);
        if (StringUtils.isNotBlank(id)) {
            int flag = mapper.updateByPrimaryKeySelective(musicComments);
            return flag > 0 ? true : false;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            int flag = mapper.deleteByPrimaryKey(id);
            return flag > 0 ? true : false;
        }
        return false;
    }

    @Override
    public List<CommentsVo> select(String mid) {

        if (StringUtils.isNotBlank(mid)) {
           return  commentsExtMapper.selectByMusic(mid);
        }
        return null;
    }

    @Override
    public Integer getCount(String mid) {
        MusicCommentsExample example=new MusicCommentsExample();
        MusicCommentsExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(mid)){
            criteria.andMidEqualTo(mid);
            return mapper.countByExample(example);
        }
        return null;
    }
}
