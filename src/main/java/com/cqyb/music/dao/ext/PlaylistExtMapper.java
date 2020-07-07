package com.cqyb.music.dao.ext;

import com.cqyb.music.model.PlaylistVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/3/1 15:39
 * @Description:
 */
public interface PlaylistExtMapper {
    List<PlaylistVo> SelectByUid(@Param("uid") String uid);
    List<PlaylistVo> SelectByExample(@Param("example") Integer example);
    List<PlaylistVo> SelectByOnLine();
    List<PlaylistVo> SelectById(@Param("plid") String plid);
    List<String> selectAll();
}
