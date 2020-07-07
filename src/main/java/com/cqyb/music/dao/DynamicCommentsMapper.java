package com.cqyb.music.dao;

import com.cqyb.music.entity.DynamicComments;
import com.cqyb.music.entity.DynamicCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicCommentsMapper {
    int countByExample(DynamicCommentsExample example);

    int deleteByExample(DynamicCommentsExample example);

    int deleteByPrimaryKey(String id);

    int insert(DynamicComments record);

    int insertSelective(DynamicComments record);

    List<DynamicComments> selectByExample(DynamicCommentsExample example);

    DynamicComments selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DynamicComments record, @Param("example") DynamicCommentsExample example);

    int updateByExample(@Param("record") DynamicComments record, @Param("example") DynamicCommentsExample example);

    int updateByPrimaryKeySelective(DynamicComments record);

    int updateByPrimaryKey(DynamicComments record);
}