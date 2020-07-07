package com.cqyb.music.controller;

import com.cqyb.music.model.MusicModel;
import com.cqyb.music.model.SearchModel;
import com.cqyb.music.service.MusicService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 17:20
 * @Description:
 */
@Api(value = "音乐管理", tags = {"音乐管理"})
@RestController
@RequestMapping("/music")
public class MusicController {
    @Autowired
    public MusicService musicService;

    @ApiOperation(value = "添加音乐")
    @PostMapping("/add")
    public JsonResult add(MusicModel musicModel,@RequestParam(value = "image", required = false) MultipartFile image,
                          @RequestParam(value = "lyrics", required = false) MultipartFile lyrics,@RequestParam(value = "mp3", required = false) MultipartFile mp3) {
        return new OkResult(musicService.saveOject(musicModel, image, lyrics, mp3));
    }

    @ApiOperation(value = "修改音乐")
    @PostMapping("/update")
    public JsonResult update(MusicModel musicModel) {
        return new OkResult(musicService.update(musicModel));
    }

    @ApiOperation(value = "删除音乐")
    @GetMapping("/delete")
    public JsonResult delete(String id) {
        return new OkResult(musicService.delete(id));
    }

    @ApiOperation(value = "搜索音乐")
    @PostMapping("/select")
    public JsonResult select(SearchModel musicSearchModel) {
        return new OkResult(musicService.select(musicSearchModel));
    }

    @ApiOperation(value = "排行榜1.下载数2.搜索量3.点击量4.评论量")
    @GetMapping("/list")
    public JsonResult selectByOrderByNumber(Integer number) {
        return new OkResult(musicService.selectOrderByNumber(number));
    }

    @ApiOperation(value = "新歌推荐")
    @GetMapping
    public JsonResult selectByCreateTime() {
        return new OkResult(musicService.selectByCreatTime());
    }
    @ApiOperation(value = "统计访问量")
    @GetMapping("/traffic")
    public JsonResult trafficStatistics(String id) {
        long num = musicService.trafficStatistics(id);
        return  new OkResult(num);
    }
    @ApiOperation(value = "分页查询音乐")
    @GetMapping("/page")
    public JsonResult pageInfo(Integer pageNum,Integer pageSize) {
        //musicService.selectByPage(pageNum,pageSize)
        return  new OkResult( );
    }
}
