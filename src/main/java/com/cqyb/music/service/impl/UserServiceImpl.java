package com.cqyb.music.service.impl;

import com.cqyb.music.dao.UserMapper;
import com.cqyb.music.entity.User;
import com.cqyb.music.entity.UserExample;
import com.cqyb.music.model.MusicVo;
import com.cqyb.music.model.UserModel;
import com.cqyb.music.service.UserService;
import com.cqyb.music.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/21 15:47
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveObject(UserModel userModel,String image) {
        if (checkRept(userModel.getUsername())) {
            return false;
        }
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        user.setId(Utils.generateUUID());
        user.setPassword(Utils.stringMD5(userModel.getPassword()));
        MultipartFile multipartFile=null;
        if(image!=null){
            multipartFile=Base64DecodeMultipartFile.base64Convert(image);
        }
        try{
            if (!multipartFile.isEmpty()||multipartFile!=null) {
                Map<String, String> map = FileUtil.uploadFile(user.getId(), multipartFile, Common.USER);
                if (map.get("code") == "true") {
                    user.setImage(map.get("msg"));
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        int flag = userMapper.insertSelective(user);
        return  flag>0?true:false;

    }

    @Override
    public boolean update(UserModel userModel, String image)  {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(userModel.getUsername())) {
            criteria.andUsernameEqualTo(userModel.getUsername());
        }
        if (StringUtils.isNotBlank(userModel.getPassword())) {
            criteria.andPasswordEqualTo(Utils.stringMD5(userModel.getPassword()));
        }
        if (StringUtils.isNotBlank(userModel.getId())) {
            criteria.andIdEqualTo(userModel.getId());
        }
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        if(userModel.getPassword()!=null&&StringUtils.isNotBlank(userModel.getPassword())){
            user.setPassword(Utils.stringMD5(userModel.getPassword()));
        }
        MultipartFile multipartFile=null;
        if(image!=null){
            multipartFile=Base64DecodeMultipartFile.base64Convert(image);
        }
        try{
            if (!multipartFile.isEmpty()||multipartFile!=null) {
                Map<String, String> map = FileUtil.uploadFile(user.getId(), multipartFile, Common.USER);
                if (map.get("code") == "true") {
                    user.setImage(map.get("msg"));
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        int flag = userMapper.updateByExampleSelective(user, example);
        return  flag>0?true:false;

    }

    @Override
    public boolean delete(String id) {
        int flag = 0;
        if (StringUtils.isNotBlank(id)) {
            flag = userMapper.deleteByPrimaryKey(id);
        }
        return  flag>0?true:false;

    }

    @Override
    public List<User> select(UserModel userModel) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(userModel.getUsername())) {
            criteria.andUsernameEqualTo(userModel.getUsername());
        }
        if (StringUtils.isNotBlank(userModel.getPassword())) {
            criteria.andPasswordEqualTo(Utils.stringMD5(userModel.getPassword()));
        }
        if(StringUtils.isNotBlank(userModel.getId())){
            criteria.andIdEqualTo(userModel.getId());
        }
        return userMapper.selectByExample(example);
    }

    @Override
    public PageInfo selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize,true); // 设定当前页码，以及当前页显示的条数
        UserExample example=new UserExample();
        List<User> list = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo;
    }

    public boolean checkRept(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(userName)) {
            criteria.andUsernameEqualTo(userName);
        }
        int flag = userMapper.countByExample(example);
        return  flag>0?true:false;

    }
}
