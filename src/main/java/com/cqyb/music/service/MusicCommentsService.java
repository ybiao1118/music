package com.cqyb.music.service;

import com.cqyb.music.entity.MusicComments;
import com.cqyb.music.model.CommentsVo;
import com.cqyb.music.model.MusicCommentsModel;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 14:38
 * @Description:
 */
public interface MusicCommentsService {
    boolean saveObject(MusicCommentsModel musicCommentsModel);
    boolean update(String id,Integer znumber );
    boolean delete(String id);
    List<CommentsVo> select(String mid);
    Integer getCount(String mid);
}
