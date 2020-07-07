package com.cqyb.music.controller;

import com.cqyb.music.model.PlaylistCommentsModel;
import com.cqyb.music.model.PlaylistModel;
import com.cqyb.music.service.PlaylistCommentsService;
import com.cqyb.music.service.PlaylistService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/24 17:49
 * @Description:
 */
@Api(value = "歌单评论管理", tags = {"歌单评论管理"})
@RestController
@RequestMapping("/playlistComments")
public class PlaylistCommentsController {
    @Autowired
    public PlaylistCommentsService playlistCommentsService;
    @Autowired
    public PlaylistService playlistService;
    @ApiOperation(value = "增加歌单评论")
    @PostMapping("/add")
    public JsonResult add(PlaylistCommentsModel playlistCommentsModel){
        boolean flag=playlistCommentsService.saveObject(playlistCommentsModel);
        if(flag){
            Integer num=playlistCommentsService.getCount(playlistCommentsModel.getPlid());
            PlaylistModel model=new PlaylistModel();
            model.setId(playlistCommentsModel.getPlid());
            model.setPnumber(num);
            boolean x=playlistService.update(model,null);
            return new OkResult(x);
        }
        return new OkResult(flag);
    }
    @ApiOperation(value = "修改点赞数量")
    @GetMapping("/update")
    public  JsonResult update(String id,Integer znumber){
        return  new OkResult(playlistCommentsService.update(id,znumber));
    }
    @ApiOperation(value = "查询歌单评论")
    @GetMapping("/select")
    public JsonResult select(String plid){
        return new OkResult(playlistCommentsService.select(plid));
    }
}
