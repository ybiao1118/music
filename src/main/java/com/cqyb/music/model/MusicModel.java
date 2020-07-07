package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/23 16:11
 * @Description:
 */
@Data
public class MusicModel {
    private String id;

    private String name;

    private String pid;

    private Integer dnumber;

    private Integer snumber;

    private Integer cnumber;

    private Integer pnumber;

    private Integer isAudit;


}
