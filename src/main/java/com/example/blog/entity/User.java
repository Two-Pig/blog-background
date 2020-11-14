package com.example.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
