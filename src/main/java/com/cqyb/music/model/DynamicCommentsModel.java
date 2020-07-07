package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 11:30
 * @Description:
 */
@Data
public class DynamicCommentsModel {
    private String id;
    @NotNull
    private String did;
    @NotNull
    private String uid;

    private String comment;

    private Integer znumber;

    private String level;

    private String parentid;

}
