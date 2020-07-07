package com.cqyb.music.controller;

import com.cqyb.music.model.DynamicModel;
import com.cqyb.music.model.DynamicVo;
import com.cqyb.music.service.DynamicService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 10:57
 * @Description:
 */
@Api(value = "动态管理",tags = {"动态管理"})
@RestController
@RequestMapping("/dynamic")
public class DynamicController {
    @Autowired
    public DynamicService dynamicService;
    @ApiOperation(value = "增加动态")
    @PostMapping("/add")
    public JsonResult add(DynamicModel dynamicModel, String image){
        return  new OkResult(dynamicService.saveObject(dynamicModel,image));
    }
    @ApiOperation(value = "修改动态")
    @PostMapping("/update")
    public JsonResult update(DynamicModel dynamicModel){
        return  new OkResult(dynamicService.update(dynamicModel));
    }
    @ApiOperation(value = "删除动态")
    @GetMapping("/delete")
    public  JsonResult delete(String id){
        return  new OkResult(dynamicService.delete(id));
    }
    @ApiOperation(value = "根据uid查询动态")
    @GetMapping("/selectUid")
    public  JsonResult selectByUid(String uid){
        return  new OkResult(dynamicService.selectByUid(uid));
    }

    @ApiOperation(value = "查询动态")
    @GetMapping("/select")
    public  JsonResult selectByZnumber(){
        return  new OkResult(dynamicService.selectByTime());
    }
    @ApiOperation(value = "根据id查询动态")
    @GetMapping("/selectId")
    public  JsonResult selectById(String id){
        List<DynamicVo> list = dynamicService.selectById(id);
        if (null == list || list.size() == 0) {
            return new OkResult(null);
        } else {
            DynamicVo dy = list.get(0);
            return new OkResult(dy);
        }

    }
}
