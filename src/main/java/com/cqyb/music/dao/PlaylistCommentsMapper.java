package com.cqyb.music.dao;

import com.cqyb.music.entity.PlaylistComments;
import com.cqyb.music.entity.PlaylistCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlaylistCommentsMapper {
    int countByExample(PlaylistCommentsExample example);

    int deleteByExample(PlaylistCommentsExample example);

    int deleteByPrimaryKey(String id);

    int insert(PlaylistComments record);

    int insertSelective(PlaylistComments record);

    List<PlaylistComments> selectByExample(PlaylistCommentsExample example);

    PlaylistComments selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PlaylistComments record, @Param("example") PlaylistCommentsExample example);

    int updateByExample(@Param("record") PlaylistComments record, @Param("example") PlaylistCommentsExample example);

    int updateByPrimaryKeySelective(PlaylistComments record);

    int updateByPrimaryKey(PlaylistComments record);
}