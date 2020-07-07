package com.cqyb.music.service.impl;

import com.cqyb.music.dao.DynamicCommentsMapper;
import com.cqyb.music.dao.ext.CommentsExtMapper;
import com.cqyb.music.entity.DynamicComments;
import com.cqyb.music.entity.DynamicCommentsExample;
import com.cqyb.music.model.CommentsVo;
import com.cqyb.music.model.DynamicCommentsModel;
import com.cqyb.music.service.DynamicCommentsService;
import com.cqyb.music.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 11:36
 * @Description:
 */
@Service
public class DynamicCommentsServiceImpl implements DynamicCommentsService {
    @Autowired
    public DynamicCommentsMapper dynamicCommentsMapper;
    @Autowired
    public CommentsExtMapper commentsExtMapper;

    @Override
    public boolean saveObject(DynamicCommentsModel dynamicCommentsModel) {
        DynamicComments dynamicComments = new DynamicComments();
        BeanUtils.copyProperties(dynamicCommentsModel, dynamicComments);
        dynamicComments.setId(Utils.generateUUID());
        dynamicComments.setTime(new Date());
        int flag = dynamicCommentsMapper.insertSelective(dynamicComments);
        return flag > 0 ? true : false;
    }

    @Override
    public boolean update(String id, Integer znumber) {
        DynamicComments dynamicComments = new DynamicComments();
        dynamicComments.setZnumber(znumber);
        dynamicComments.setId(id);
        if (StringUtils.isNotBlank(id)) {
            int flag = dynamicCommentsMapper.updateByPrimaryKeySelective(dynamicComments);
            return flag > 0 ? true : false;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            int flag = dynamicCommentsMapper.deleteByPrimaryKey(id);
            return flag > 0 ? true : false;
        }
        return false;
    }

    @Override
    public List<CommentsVo> select(String did) {
        if(StringUtils.isNotBlank(did)){
            return commentsExtMapper.selectByDynamic(did);
        }else {
            return null;
        }

    }

    @Override
    public Integer getCount(String did) {
        DynamicCommentsExample example=new DynamicCommentsExample();
        DynamicCommentsExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(did)){
            criteria.andDidEqualTo(did);
            return dynamicCommentsMapper.countByExample(example);
        }
        return null;
    }
}
