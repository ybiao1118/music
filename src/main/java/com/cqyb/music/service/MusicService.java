package com.cqyb.music.service;

import com.cqyb.music.model.MusicModel;
import com.cqyb.music.model.SearchModel;
import com.cqyb.music.model.MusicVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 16:32
 * @Description:
 */
public interface MusicService {
    boolean saveOject(MusicModel musicModel, MultipartFile image,MultipartFile lyrics,MultipartFile mp3);
    boolean update(MusicModel musicModel);
    boolean delete(String id);
    List<MusicVo> select(SearchModel musicSearchModel);
    List<MusicVo> selectOrderByNumber(Integer number);
    List<MusicVo> selectByCreatTime();
    List<String> selectAll();
    //访问量统计
    long trafficStatistics(String id);
    PageInfo selectByPage(Integer pageNum,Integer pageSize);
}
