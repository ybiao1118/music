package com.cqyb.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqyb.music.entity.User;
import com.cqyb.music.model.PlayerModel;
import com.cqyb.music.model.PlaylistModel;
import com.cqyb.music.model.UserModel;
import com.cqyb.music.service.PlaylistService;
import com.cqyb.music.service.UserService;
import com.cqyb.music.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/21 15:50
 * @Description:
 */
@Api(value = "用户管理", tags = {"用户管理"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PlaylistService playlistService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    public JsonResult add(UserModel userModel,String image)  {
        boolean flag=userService.saveObject(userModel,image);
        //如果用户注册成功，创建一个默认歌单
        if(flag){
            List<User> list=  userService.select(userModel);
            User user=list.get(0);
            System.out.println(user);
            if(user!=null){
                PlaylistModel playlistModel=new PlaylistModel();
                MultipartFile file=null;
                playlistModel.setName("我喜欢的音乐");
                playlistModel.setUid(user.getId());
                return new OkResult(playlistService.saveObject(playlistModel,image));
            }
        }
        return new OkResult(false);
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("/update")
    public JsonResult update(UserModel userModel,String image) {
        return new OkResult(userService.update(userModel,image));
    }

    @ApiOperation(value = "查询用户")
    @PostMapping("/select")
    public JsonResult select(UserModel userModel) {
        List<User> list = userService.select(userModel);
        if (null == list || list.size() == 0) {
            return new OkResult(null);
        } else {
            User user = list.get(0);
            return new OkResult(user);
        }

    }

    @ApiOperation(value = "删除用户")
    @GetMapping("/delete")
    public JsonResult delete(String id) {
        if(StringUtils.isNotBlank(id)){
            return new OkResult(userService.delete(id));
        }
        else {
            return new OkResult(false);
        }
    }
    @ApiOperation(value = "分页查询用户")
    @GetMapping("/page")
    public JsonResult pageInfo(Integer pageNum,Integer pageSize) {
        //musicService.selectByPage(pageNum,pageSize)
        return  new OkResult(userService.selectByPage(pageNum,pageSize));
    }



}
