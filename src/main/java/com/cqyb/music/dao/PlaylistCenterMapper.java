package com.cqyb.music.dao;

import com.cqyb.music.entity.PlaylistCenter;
import com.cqyb.music.entity.PlaylistCenterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlaylistCenterMapper {
    int countByExample(PlaylistCenterExample example);

    int deleteByExample(PlaylistCenterExample example);

    int deleteByPrimaryKey(String id);

    int insert(PlaylistCenter record);

    int insertSelective(PlaylistCenter record);

    List<PlaylistCenter> selectByExample(PlaylistCenterExample example);

    PlaylistCenter selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PlaylistCenter record, @Param("example") PlaylistCenterExample example);

    int updateByExample(@Param("record") PlaylistCenter record, @Param("example") PlaylistCenterExample example);

    int updateByPrimaryKeySelective(PlaylistCenter record);

    int updateByPrimaryKey(PlaylistCenter record);
}