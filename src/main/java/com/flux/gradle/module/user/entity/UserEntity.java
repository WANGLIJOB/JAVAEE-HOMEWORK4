package com.flux.gradle.module.user.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author G
 * @Description 实体类$
 * @Date 2018/10/11 18:15
 **/
@Data
public class UserEntity implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String createTime;
}
