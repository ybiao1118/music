package com.cqyb.music.schedule;

import com.cqyb.music.entity.Player;
import com.cqyb.music.model.PlayerModel;
import com.cqyb.music.service.PlayerService;
import com.cqyb.music.util.Common;
import com.cqyb.music.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @Auther: yanbiao
 * @Date: 2019/4/12 15:51
 * @Description:
 */
@Component
public class PlayerSchedule {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerSchedule.class);
    @Autowired
    public PlayerService playerService;
    @Autowired
    public RedisUtil redis;
    //0 0/5 0 * * ? 每5分钟执行一次
    @Scheduled(cron = "0 0/5 * * * ? ")
    //@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    public void count(){
        List<String> list=playerService.selectAll();
        for(String id:list){
            String key = Common.PLAYER_KEY+Common.TONGJI+id;
            if(redis.hasKey(key)){
                if(redis.get(key) instanceof Integer)
                    playerService.updateSnumber(id,(Integer) redis.get(key));

            }
        }
        LOGGER.info("歌手统计完成=======》");

    }

}
