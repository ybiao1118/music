package com.cqyb.music.dao.ext;

import com.cqyb.music.model.DynamicVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/3/25 09:55
 * @Description:
 */
public interface DynamicExtMapper {
    List<DynamicVo> selectByTime();
    List<DynamicVo> selectByTimeAndUid(@Param("uid") String uid);
    List<DynamicVo> selectByTimeAndId(@Param("id") String id);
}
