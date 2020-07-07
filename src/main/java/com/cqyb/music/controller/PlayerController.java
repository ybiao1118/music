package com.cqyb.music.controller;

import com.cqyb.music.entity.Player;
import com.cqyb.music.model.PlayerModel;
import com.cqyb.music.service.PlayerService;
import com.cqyb.music.util.JsonResult;
import com.cqyb.music.util.OkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/23 17:41
 * @Description:
 */
@Api(value = "歌手管理", tags = {"歌手管理"})
@RestController
@RequestMapping("/play")
public class PlayerController {
    @Autowired
    public PlayerService playerService;

    @ApiOperation(value = "添加歌手")
    @PostMapping("/add")
    public JsonResult add(MultipartFile multipartFile, PlayerModel playerModel) {
        return new OkResult(playerService.saveObject(playerModel, multipartFile));
    }

    @ApiOperation(value = "修改歌手")
    @PostMapping("/update")
    public JsonResult update(MultipartFile multipartFile, PlayerModel playerModel)  {
        return new OkResult(playerService.update(playerModel, multipartFile));
    }

    @ApiOperation(value = "查询歌手")
    @PostMapping("/select")
    public JsonResult select(PlayerModel playerModel) {
        List<Player> list = playerService.select(playerModel);
        if (list == null || list.size() == 0) {
            return new OkResult(null);
        } else {
            return new OkResult(list);
        }
    }
    @ApiOperation(value = "删除歌手")
    @GetMapping("/delete")
    public JsonResult delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            return new OkResult(playerService.delete(id));
        } else {
            return new OkResult(false);
        }
    }
    @ApiOperation(value = "查询热门歌手")
    @GetMapping("/selecthot")
    public JsonResult selectByHot() {
        List<Player> list = playerService.selectByHot();
        if (list == null || list.size() == 0) {
            return new OkResult(null);
        } else {
            return new OkResult(list);
        }
    }
    @ApiOperation(value = "根据拼音查询歌手")
    @GetMapping("/selectpy")
    public JsonResult selectByPinYin(String pingyin) {
        List<Player> list = playerService.selectByPinYinAndHot(pingyin);
        if (list == null || list.size() == 0) {
            return new OkResult(null);
        } else {
            return new OkResult(list);
        }
    }
    @ApiOperation(value = "统计访问量")
    @GetMapping("/traffic")
    public JsonResult trafficStatistics(String id) {
        long num = playerService.trafficStatistics(id);
       return  new OkResult(num);
    }
    @ApiOperation(value = "分页查询歌手")
    @GetMapping("/page")
    public JsonResult pageInfo(Integer pageNum,Integer pageSize) {
        //musicService.selectByPage(pageNum,pageSize)
        return  new OkResult(playerService.selectByPage(pageNum,pageSize));
    }


}
