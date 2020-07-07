package com.cqyb.music.dao.ext;

import com.cqyb.music.model.CommentsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/29 11:07
 * @Description:
 */
public interface CommentsExtMapper {
    List<CommentsVo> selectByDynamic(@Param("xid") String xid);
    List<CommentsVo> selectByMusic(@Param("xid") String xid);
    List<CommentsVo> selectByPlayList(@Param("xid") String xid);
}
