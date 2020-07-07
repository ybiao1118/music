package com.cqyb.music.schedule;

import com.cqyb.music.model.PlaylistModel;
import com.cqyb.music.service.PlaylistService;
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
 * @Date: 2019/4/12 17:47
 * @Description:
 */
@Component
public class PlaylistSchedule {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistSchedule.class);
    @Autowired
    public PlaylistService playlistService;
    @Autowired
    public RedisUtil redis;
    //0 0/5 0 * * ? 每5分钟执行一次
    @Scheduled(cron = "0 0/5 * * * ? ")
    //@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    public void count(){
        List<String> list=playlistService.selectAll();
        for(String id:list){
            String key = Common.PLAYLIST_KEY+Common.TONGJI+id;
            if(redis.hasKey(key)){
                PlaylistModel model=new PlaylistModel();
                model.setId(id);
                if(redis.get(key) instanceof Integer){
                    model.setCnumber((Integer) redis.get(key));
                    playlistService.update(model,null);
                }
            }
        }
        LOGGER.info("歌单统计完成=======》");

    }
}
