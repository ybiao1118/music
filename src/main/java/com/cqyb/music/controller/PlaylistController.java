package com.cqyb.music.controller;

import com.cqyb.music.model.PlaylistModel;
import com.cqyb.music.model.PlaylistVo;
import com.cqyb.music.service.PlaylistService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/24 14:54
 * @Description:
 */
@Api(value = "歌单管理", tags = {"歌单管理"})
@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    public PlaylistService playlistService;
    @ApiOperation(value = "新增歌单")
    @PostMapping("/add")
    public JsonResult add(PlaylistModel playlistModel, String image){
        return new OkResult(playlistService.saveObject(playlistModel,image));
    }
    @ApiOperation(value = "修改歌单")
    @PostMapping("/update")
    public  JsonResult update(PlaylistModel playlistModel,String image){
        return new OkResult(playlistService.update(playlistModel,image));
    }
    @ApiOperation(value = "删除歌单")
    @GetMapping("/delete")
    public  JsonResult delete(String id ){
        return  new OkResult(playlistService.delete(id));
    }
    @ApiOperation(value = "根据用户id查询歌单")
    @GetMapping("/select")
    public JsonResult select(String uid){
        if(StringUtils.isNotBlank(uid)){
            return  new OkResult(playlistService.selectByUid(uid));
        }else{
            return  new OkResult(false);
        }

    }
    @ApiOperation(value = "查询歌单排行榜,1.评论量，2.点击量")
    @GetMapping("/selectByExample")
    public JsonResult selectByExample(Integer num){
        if(num!=null){
            return  new OkResult(playlistService.selectByExample(num));
        }else{
            return  new OkResult(false);
        }

    }
    @ApiOperation(value = "查询上线歌单")
    @GetMapping("/selectByOnline")
    public JsonResult selectByOnLine(){
            return  new OkResult(playlistService.selectByOnLine());
    }
    @ApiOperation(value = "根据id查询歌单")
    @GetMapping ("/selectId")
    public JsonResult selectId( String id) {
        List<PlaylistVo> list = playlistService.selectById(id);
        if (null == list || list.size() == 0) {
            return new OkResult(null);
        } else {
            PlaylistVo pl = list.get(0);
            return new OkResult(pl);
        }

    }
    @ApiOperation(value = "统计访问量")
    @GetMapping("/traffic")
    public JsonResult trafficStatistics(String id) {
        long num = playlistService.trafficStatistics(id);
        return  new OkResult(num);
    }
}
