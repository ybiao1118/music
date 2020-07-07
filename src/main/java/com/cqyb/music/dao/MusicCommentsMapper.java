package com.cqyb.music.dao;

import com.cqyb.music.entity.MusicComments;
import com.cqyb.music.entity.MusicCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicCommentsMapper {
    int countByExample(MusicCommentsExample example);

    int deleteByExample(MusicCommentsExample example);

    int deleteByPrimaryKey(String id);

    int insert(MusicComments record);

    int insertSelective(MusicComments record);

    List<MusicComments> selectByExample(MusicCommentsExample example);

    MusicComments selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MusicComments record, @Param("example") MusicCommentsExample example);

    int updateByExample(@Param("record") MusicComments record, @Param("example") MusicCommentsExample example);

    int updateByPrimaryKeySelective(MusicComments record);

    int updateByPrimaryKey(MusicComments record);
}