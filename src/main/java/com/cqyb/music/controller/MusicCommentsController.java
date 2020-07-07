package com.cqyb.music.controller;

import com.cqyb.music.model.MusicCommentsModel;
import com.cqyb.music.model.MusicModel;
import com.cqyb.music.service.MusicCommentsService;
import com.cqyb.music.service.MusicService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 14:48
 * @Description:
 */
@Api(value = "音乐评论管理", tags = {"音乐评论管理"})
@RestController
@RequestMapping("/musicComments")
public class MusicCommentsController {

    @Autowired
    public MusicCommentsService musicCommentsService;
    @Autowired
    public MusicService musicService;

    @ApiOperation(value = "增加音乐评论")
    @PostMapping("/add")
    public JsonResult add(MusicCommentsModel musicCommentsModel) {
        boolean flag=musicCommentsService.saveObject(musicCommentsModel);
        if(flag){
            int num=musicCommentsService.getCount(musicCommentsModel.getMid());
            MusicModel model =new MusicModel();
            model.setId(musicCommentsModel.getMid());
            model.setPnumber(num);
           boolean x= musicService.update(model);
           return  new OkResult(x);
        }else{
            return new OkResult(flag);
        }

    }

    @ApiOperation(value = "修改点赞数量")
    @GetMapping("/update")
    public JsonResult update(String id, Integer znumber) {
        return new OkResult(musicCommentsService.update(id, znumber));
    }

    @ApiOperation(value = "删除音乐评论")
    @GetMapping("/delete")
    public JsonResult delete(String id) {
        return new OkResult(musicCommentsService.delete(id));
    }

    @ApiOperation(value = "查询音乐评论")
    @GetMapping("/select")
    public JsonResult selete(String mid) {
        return new OkResult(musicCommentsService.select(mid));
    }
}
