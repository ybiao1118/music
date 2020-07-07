package com.cqyb.music.controller;

import com.cqyb.music.model.DynamicCommentsModel;
import com.cqyb.music.model.DynamicModel;
import com.cqyb.music.service.DynamicCommentsService;
import com.cqyb.music.service.DynamicService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 14:02
 * @Description:
 */
@Api(value = "动态评论管理", tags = {"动态评论管理"})
@RestController
@RequestMapping("/dynamicComments")
public class DynamicCommentsController {
    @Autowired
    public DynamicCommentsService dynamicCommentsService;
    @Autowired
    public DynamicService dynamicService;
    @ApiOperation(value = "增加动态评论")
    @PostMapping("/add")
    public JsonResult add(DynamicCommentsModel dynamicCommentsModel) {
        boolean flag=dynamicCommentsService.saveObject(dynamicCommentsModel);
        if(flag){
            Integer num=dynamicCommentsService.getCount(dynamicCommentsModel.getDid());
            DynamicModel model=new DynamicModel();
            model.setId(dynamicCommentsModel.getDid());
            model.setPnumber(num);

            new OkResult(  dynamicService.update(model));
        }
        return new OkResult(flag);
    }

    @ApiOperation(value = "修改点赞数量")
    @GetMapping("/update")
    public JsonResult update(String id, Integer znumber) {
        return new OkResult(dynamicCommentsService.update(id, znumber));
    }

    @ApiOperation(value = "删除动态评论")
    @GetMapping("/delete")
    public JsonResult delete(String id) {
        return new OkResult(dynamicCommentsService.delete(id));
    }

    @ApiOperation(value = "查询动态留言")
    @GetMapping("/select")
    public JsonResult selete(String did) {
        return new OkResult(dynamicCommentsService.select(did));
    }
}
