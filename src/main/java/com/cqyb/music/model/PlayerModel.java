package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/23 16:30
 * @Description:
 */
@Data
public class PlayerModel {
    private String id;
    @NotNull
    private String name;

    private String comment;

    private Integer snumber;

    private String pinyin;

}
