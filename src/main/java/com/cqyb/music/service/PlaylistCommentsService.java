package com.cqyb.music.service;

import com.cqyb.music.entity.PlaylistComments;
import com.cqyb.music.model.CommentsVo;
import com.cqyb.music.model.PlaylistCommentsModel;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/24 17:10
 * @Description:
 */
public interface PlaylistCommentsService {
    boolean saveObject(PlaylistCommentsModel playlistCommentsModel);
    boolean delete(String id);
    boolean update(String id,int  znumber);
    List<CommentsVo> select(String plid);
    Integer getCount(String plid);
}
