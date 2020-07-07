package com.cqyb.music.service.impl;

import com.cqyb.music.dao.DynamicMapper;
import com.cqyb.music.dao.ext.DynamicExtMapper;
import com.cqyb.music.entity.Dynamic;
import com.cqyb.music.entity.DynamicExample;
import com.cqyb.music.model.DynamicModel;
import com.cqyb.music.model.DynamicVo;
import com.cqyb.music.service.DynamicService;
import com.cqyb.music.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 10:26
 * @Description:
 */
@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    public DynamicMapper dynamicMapper;
    @Autowired
    public DynamicExtMapper dynamicExtMapper;

    @Override
    public boolean saveObject(DynamicModel dynamicModel, String image) {
        Dynamic dynamic = new Dynamic();
        BeanUtils.copyProperties(dynamicModel, dynamic);
        dynamic.setId(Utils.generateUUID());
        dynamic.setTime(new Date());
        MultipartFile multipartFile=null;
        if(image!=null){
            multipartFile=Base64DecodeMultipartFile.base64Convert(image);
        }
        if (!multipartFile.isEmpty() || multipartFile != null) {
                Map<String,String> map=FileUtil.uploadFile(dynamic.getId(), multipartFile, Common.DYNAMIC);
                if (map.get("code")=="true") {
                    dynamic.setFile(map.get("msg"));
                }
        }

        int flag = dynamicMapper.insertSelective(dynamic);
        return flag > 0 ? true : false;
    }

    @Override
    public boolean update(DynamicModel dynamicModel) {
        DynamicExample example = new DynamicExample();
        DynamicExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(dynamicModel.getId())) {
            criteria.andIdEqualTo(dynamicModel.getId());
        } else {
            return false;
        }
        Dynamic dynamic = new Dynamic();
        BeanUtils.copyProperties(dynamicModel, dynamic);
//        if (!multipartFile.isEmpty() || multipartFile != null) {
//            Map<String,String> map=FileUtil.uploadFile(dynamic.getId(), multipartFile, Common.DYNAMIC);
//            if (map.get("code")=="true") {
//                dynamic.setFile(map.get("msg"));
//            }
//        }
        int flag = dynamicMapper.updateByExampleSelective(dynamic, example);
        return flag > 0 ? true : false;
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            int flag = dynamicMapper.deleteByPrimaryKey(id);
            return flag > 0 ? true : false;
        }
        return false;
    }

    @Override
    public List<DynamicVo> selectByUid(String uid) {
        if (StringUtils.isNotBlank(uid)) {
            return  dynamicExtMapper.selectByTimeAndUid(uid);
        }
        return null;
    }

    @Override
    public List<DynamicVo> selectByTime() {
        return dynamicExtMapper.selectByTime();
    }

    @Override
    public List<DynamicVo> selectById(String id) {
        return dynamicExtMapper.selectByTimeAndId(id);
    }
}
