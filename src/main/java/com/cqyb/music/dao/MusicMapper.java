package com.cqyb.music.dao;

import com.cqyb.music.entity.Music;
import com.cqyb.music.entity.MusicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicMapper {
    int countByExample(MusicExample example);

    int deleteByExample(MusicExample example);

    int deleteByPrimaryKey(String id);

    int insert(Music record);

    int insertSelective(Music record);

    List<Music> selectByExample(MusicExample example);

    Music selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByExample(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
}