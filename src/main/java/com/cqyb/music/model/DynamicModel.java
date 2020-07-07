package com.cqyb.music.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/25 10:16
 * @Description:
 */
@Data
public class DynamicModel {

    private String id;

    @NotNull
    private String uid;

    private Integer znumber;

    private Integer fnumber;

    private Integer pnumber;

    private String comment;

}
