package com.cqyb.music.dao.ext;

import com.cqyb.music.model.SearchModel;
import com.cqyb.music.model.MusicVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/28 14:10
 * @Description:
 */
public interface MusicExtMapper {
    /**
     * 查询歌曲
     * @param musicSearchModel
     * @return
     */
    List<MusicVo> selectByExample(@Param("model") SearchModel musicSearchModel);

    /**
     * 查询排行榜歌曲
     * @param example
     * @return
     */
    List<MusicVo> selectOrderByExample(@Param("example") Integer example);

    /**
     * 查询最新歌曲

     * @return
     */
    List<MusicVo> selectByCreateTime();

    /**
     * 查询歌单里的歌曲
     * @param plid
     * @return
     */
    List<MusicVo> selectByPlid(@Param("plid") String plid);

    List<String> selectAll();
}
