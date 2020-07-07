package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: yanbiao
 * @Date: 2019/3/1 15:01
 * @Description:
 */
@Data
public class PlaylistVo {
    private String id;
    @NotNull
    private String uid;

    private Integer pnumber;

    private Integer cnumber;

    private Integer isOnline;

    private String name;

    private  String uname;

    private  String image;

    private  String uimage;

}
