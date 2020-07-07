package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: yanbiao
 * @Date: 2019/3/25 09:45
 * @Description:
 */
@Data
public class DynamicVo {
    private String id;

    private String uid;

    private Integer znumber;

    private Integer fnumber;

    private Integer pnumber;

    private String comment;

    private  String  file;

    private String time;

    private  String  uname;

    private  String ucity;

    private  String uimage;




}
