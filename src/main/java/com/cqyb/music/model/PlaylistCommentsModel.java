package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/24 17:01
 * @Description:
 */
@Data
public class PlaylistCommentsModel {
    private String id;
    @NotNull
    private String plid;
    @NotNull
    private String uid;

    private String comment;

    private Integer znumber;

    private String level;

    private String parentid;

}
