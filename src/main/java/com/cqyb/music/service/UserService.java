package com.cqyb.music.service;

import com.cqyb.music.entity.User;
import com.cqyb.music.model.UserModel;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/21 15:45
 * @Description:
 */
public interface UserService {
    boolean saveObject(UserModel  userModel, String image) ;
    boolean update(UserModel  userModel,String image) ;
    boolean  delete(String id);
    List<User> select(UserModel  userModel);
    PageInfo selectByPage(Integer pageNum,Integer pageSize);
}
