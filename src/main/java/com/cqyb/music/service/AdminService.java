package com.cqyb.music.service;

import com.cqyb.music.entity.Admin;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/3/26 13:54
 * @Description:
 */
public interface AdminService {
    List<Admin> select(Admin admin);
    boolean update(Admin admin);
}
