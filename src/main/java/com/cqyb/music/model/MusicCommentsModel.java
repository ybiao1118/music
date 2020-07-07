package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 14:32
 * @Description:
 */
@Data
public class MusicCommentsModel {
    private String id;
    @NotNull
    private String mid;
    @NotNull
    private String uid;

    private String comment;

    private Integer znumber;

    private String level;

    private String parentid;

}
