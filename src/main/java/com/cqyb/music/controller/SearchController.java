package com.cqyb.music.controller;

import com.cqyb.music.entity.Player;
import com.cqyb.music.model.MusicVo;
import com.cqyb.music.model.PlayerModel;
import com.cqyb.music.model.SearchModel;
import com.cqyb.music.service.MusicService;
import com.cqyb.music.service.PlayerService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/28 15:53
 * @Description:
 */
@Api(value = "搜索管理",tags = "搜索管理")
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    public MusicService musicService;
    @Autowired
    public PlayerService playerService;
    @ApiOperation(value = "关键字搜索")
    @GetMapping
    public JsonResult searchKeyWord(String keyWord){
        SearchModel searchModel=new SearchModel();
        searchModel.setKeyWord(keyWord);
        List<MusicVo> list=musicService.select(searchModel);
        OkResult result =new OkResult();
        if(list==null||list.size()==0){
            PlayerModel model=new PlayerModel();
            model.setName(keyWord);
            List<Player> list1=playerService.select(model);
            if(list1==null||list1.size()==0){
                result.setMessage("无结果");
                result.setData(null);
                return  result;
            }
            result.setMessage("歌手");
            result.setData(list1);
            return result;
        }else{
            result.setMessage("音乐");
            result.setData(list);
            return  result;
        }
    }
}
