package com.cqyb.music.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/22 09:37
 * @Description:
 */
@Data
public class UserModel implements Serializable {
    private String id;

    @NotNull
    private String username;
    @NotNull
    private String password;

    private String name;

    private String sex;

    private Integer age;

    private String city;

    private String introduce;

    private static final long serialVersionUID = 1L;
}
