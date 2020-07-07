package com.cqyb.music.service;

import com.cqyb.music.entity.Player;
import com.cqyb.music.model.PlayerModel;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/23 16:35
 * @Description:
 */
public interface PlayerService {
    boolean saveObject(PlayerModel playerModel, MultipartFile multipartFile) ;
    boolean update(PlayerModel playerModel,MultipartFile multipartFile);
    List<Player> select(PlayerModel playerModel);
    boolean delete(String id);
    List<Player> selectByHot();
    List<Player> selectByPinYinAndHot(String pinyin);
    //访问量统计
    long trafficStatistics(String id);
    List<String> selectAll();
    boolean updateSnumber(String id,Integer num);
    PageInfo selectByPage(Integer pageNum, Integer pageSize);

}
