package com.cqyb.music.dao;

import com.cqyb.music.entity.Dynamic;
import com.cqyb.music.entity.DynamicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicMapper {
    int countByExample(DynamicExample example);

    int deleteByExample(DynamicExample example);

    int deleteByPrimaryKey(String id);

    int insert(Dynamic record);

    int insertSelective(Dynamic record);

    List<Dynamic> selectByExample(DynamicExample example);

    Dynamic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dynamic record, @Param("example") DynamicExample example);

    int updateByExample(@Param("record") Dynamic record, @Param("example") DynamicExample example);

    int updateByPrimaryKeySelective(Dynamic record);

    int updateByPrimaryKey(Dynamic record);
}