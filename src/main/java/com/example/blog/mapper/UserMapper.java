package com.example.blog.mapper;

import com.example.blog.entity.User;

import java.util.List;

public interface UserMapper extends TemplateMapper<User>{
    User queryUserByUserName(String username);
}
