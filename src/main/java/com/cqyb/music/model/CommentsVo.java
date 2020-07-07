package com.cqyb.music.model;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/29 10:50
 * @Description:
 */
@Data
public class CommentsVo {
    private String name;
    private String image;
    private String id;

    private String xid;

    private String comment;

    private Integer znumber;

    private String level;

    private String parentid;
    private Date time;

}
