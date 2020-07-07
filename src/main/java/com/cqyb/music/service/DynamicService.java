package com.cqyb.music.service;

import com.cqyb.music.entity.Dynamic;
import com.cqyb.music.model.DynamicModel;
import com.cqyb.music.model.DynamicVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 10:20
 * @Description:
 */
public interface DynamicService {
    boolean saveObject(DynamicModel dynamicModel, String image);
    boolean update(DynamicModel dynamicModel);
    boolean delete(String id);
    List<DynamicVo> selectByUid(String uid);
    List<DynamicVo> selectByTime();
    List<DynamicVo> selectById(String id);

}
