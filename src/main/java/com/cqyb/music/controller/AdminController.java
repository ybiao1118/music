package com.cqyb.music.controller;

import com.cqyb.music.entity.Admin;
import com.cqyb.music.service.AdminService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/3/26 14:08
 * @Description:
 */
@Api(value = "管理员管理", tags = {"管理员管理"})
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @ApiOperation(value = "查询用户")
    @GetMapping("/select")
    public JsonResult select(Admin admin, HttpServletRequest request){
        if(StringUtils.isNotBlank(admin.getAdminname())&&StringUtils.isNotBlank(admin.getPassword())){
            List<Admin> list=adminService.select(admin);
            if(list.size()!=0){
                Admin admin1=new Admin();
                admin1=list.get(0);
                if(admin1!=null){
                    HttpSession session=request.getSession();
                    session.setAttribute("admin",admin1);
                }
                return new OkResult(admin1);
            }

        }
        return  new OkResult(null);
    }
    @ApiOperation(value = "修改用户")
    @PostMapping("/update")
    public  JsonResult update(Admin admin){
        if(StringUtils.isNotBlank(admin.getId())&&StringUtils.isNotBlank(admin.getAdminname())){
            return new OkResult(adminService.update(admin));
        }
       return new OkResult(false);
    }
}
