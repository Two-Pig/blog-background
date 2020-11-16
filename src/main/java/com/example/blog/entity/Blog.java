package com.example.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class Blog<T> {
    private Integer id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentable;
    private boolean recommend;
    private boolean published;
    private Integer typeId;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private List<T> tags= new ArrayList<>();
}
