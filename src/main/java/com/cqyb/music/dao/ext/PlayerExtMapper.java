package com.cqyb.music.dao.ext;

import com.cqyb.music.entity.Player;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/3/19 17:51
 * @Description:
 */
public interface PlayerExtMapper {
    List<Player> selectByHot();
    List<Player> selectByPinYinAndHot(@Param("pinyin") String pinyin);
    List<String> selectAll();
}
