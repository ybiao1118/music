package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/24 10:52
 * @Description:
 */
@Data
public class PlaylistModel {
    private String id;
    @NotNull
    private String uid;

    private Integer pnumber;

    private Integer cnumber;

    private Integer isOnline;

    private String name;
}
