package com.cqyb.music.controller;

import com.cqyb.music.entity.PlaylistCenter;
import com.cqyb.music.service.PlaylistCenterService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 15:21
 * @Description:
 */
@Api(value = "歌单中间层管理", tags = {"歌单中间层管理"})
@RestController
@RequestMapping("/playlistCenter")
public class PlaylistCenterController {
    @Autowired
    public PlaylistCenterService playlistCenterService;

    @ApiOperation(value = "添加歌曲到歌单")
    @PostMapping("/add")
    public JsonResult add(PlaylistCenter playlistCenter) {
        return new OkResult(playlistCenterService.saveObject(playlistCenter));
    }

    @ApiOperation(value = "删除歌单里的歌曲")
    @PostMapping("/delete")
    public JsonResult delete(PlaylistCenter playlistCenter) {
        return new OkResult(playlistCenterService.delete(playlistCenter));
    }
    @ApiOperation(value = "查询歌单里的歌曲")
    @GetMapping
    public  JsonResult select(String plid){
        return  new OkResult(playlistCenterService.select(plid));
    }
}
