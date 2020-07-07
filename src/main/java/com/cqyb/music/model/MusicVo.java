package com.cqyb.music.model;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/28 14:50
 * @Description:
 */
@Data
public class MusicVo {
    private String id;

    private String name;

    private String pid;

    private String image;

    private String mp3;

    private String lyrics;

    private Integer dnumber;

    private Integer snumber;

    private Integer cnumber;

    private Integer pnumber;

    private  String pname;
    private Date createTime;
}
