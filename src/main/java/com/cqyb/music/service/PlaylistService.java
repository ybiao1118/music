package com.cqyb.music.service;

import com.cqyb.music.entity.Playlist;
import com.cqyb.music.model.PlaylistModel;
import com.cqyb.music.model.PlaylistVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/24 10:54
 * @Description:
 */
public interface PlaylistService {
    boolean saveObject(PlaylistModel playlistModel, String image);
    boolean delete(String id);
    boolean update(PlaylistModel playlistModel,String image);
    List<PlaylistVo> selectByUid(String uid);
    List<PlaylistVo> selectByExample(Integer num);
    List<PlaylistVo> selectByOnLine();
    List<PlaylistVo> selectById(String id);
    List<String> selectAll();
    //访问量统计
    long trafficStatistics(String id);
}
