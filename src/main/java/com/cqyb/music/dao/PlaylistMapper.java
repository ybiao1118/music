package com.cqyb.music.dao;

import com.cqyb.music.entity.Playlist;
import com.cqyb.music.entity.PlaylistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlaylistMapper {
    int countByExample(PlaylistExample example);

    int deleteByExample(PlaylistExample example);

    int deleteByPrimaryKey(String id);

    int insert(Playlist record);

    int insertSelective(Playlist record);

    List<Playlist> selectByExample(PlaylistExample example);

    Playlist selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Playlist record, @Param("example") PlaylistExample example);

    int updateByExample(@Param("record") Playlist record, @Param("example") PlaylistExample example);

    int updateByPrimaryKeySelective(Playlist record);

    int updateByPrimaryKey(Playlist record);
}