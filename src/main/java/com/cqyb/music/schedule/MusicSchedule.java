package com.cqyb.music.schedule;

import com.cqyb.music.model.MusicModel;
import com.cqyb.music.service.MusicService;
import com.cqyb.music.util.Common;
import com.cqyb.music.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: yanbiao
 * @Date: 2019/4/12 18:22
 * @Description:
 */
@Component
public class MusicSchedule {
    private static final Logger LOGGER = LoggerFactory.getLogger(MusicSchedule.class);
    @Autowired
    public MusicService musicService;
    @Autowired
    public RedisUtil redis;
    //0 0/5 0 * * ? 每5分钟执行一次
    @Scheduled(cron = "0 0/5 * * * ? ")
    //@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    public void count(){
        List<String> list=musicService.selectAll();
        for(String id:list){
            String key = Common.MUSIC_KEY+ Common.TONGJI+id;
            MusicModel model =new MusicModel();
            model.setId(id);
            if(redis.hasKey(key)){
                if(redis.get(key) instanceof Integer)
                {
                    model.setCnumber((Integer) redis.get(key));
                    musicService.update(model);
                }


            }
        }
        LOGGER.info("歌曲统计完成=======》");

    }

}
