package com.cqyb.music.service;

import com.cqyb.music.entity.PlaylistCenter;
import com.cqyb.music.model.MusicVo;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 15:11
 * @Description:
 */
public interface PlaylistCenterService {
    boolean saveObject(PlaylistCenter playlistCenter);
    boolean delete(PlaylistCenter playlistCenter);
    List<MusicVo> select(String plid);
}
