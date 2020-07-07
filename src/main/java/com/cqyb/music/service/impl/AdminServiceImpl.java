package com.cqyb.music.service.impl;

import com.cqyb.music.dao.AdminMapper;
import com.cqyb.music.entity.Admin;
import com.cqyb.music.entity.AdminExample;
import com.cqyb.music.service.AdminService;
import com.cqyb.music.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/3/26 13:57
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> select(Admin admin) {
        AdminExample example=new AdminExample();
        AdminExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(admin.getAdminname())){
            criteria.andAdminnameEqualTo(admin.getAdminname());
        }
        if (StringUtils.isNotBlank(admin.getPassword()))
        {
            criteria.andPasswordEqualTo(Utils.stringMD5(admin.getPassword()));
        }
       return adminMapper.selectByExample(example);


    }

    @Override
    public boolean update(Admin admin) {
        AdminExample example=new AdminExample();
        AdminExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(admin.getAdminname())){
            criteria.andAdminnameEqualTo(admin.getAdminname());
        }
        if (StringUtils.isNotBlank(admin.getId()))
        {
            criteria.andIdEqualTo(admin.getId());
        }
        Admin admin1=new Admin();
        BeanUtils.copyProperties(admin,admin1);
        if(admin.getPassword()!=null&&StringUtils.isNotBlank(admin.getPassword())){
            admin1.setPassword(Utils.stringMD5(admin.getPassword()));
        }
        int flag = adminMapper.updateByExampleSelective(admin1, example);
        return  flag>0?true:false;
    }
}
