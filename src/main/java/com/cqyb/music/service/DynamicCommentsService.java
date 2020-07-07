package com.cqyb.music.service;

import com.cqyb.music.entity.DynamicComments;
import com.cqyb.music.model.CommentsVo;
import com.cqyb.music.model.DynamicCommentsModel;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 11:32
 * @Description:
 */
public interface DynamicCommentsService {
    boolean saveObject(DynamicCommentsModel dynamicCommentsModel);
    boolean update(String id,Integer znumber );
    boolean delete(String id);
    List<CommentsVo> select(String did);
    Integer getCount(String did);
}
