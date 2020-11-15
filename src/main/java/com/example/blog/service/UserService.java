package com.example.blog.service;

import com.example.blog.entity.Type;
import com.example.blog.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    String login(User user, HttpSession session);
    Map queryUserByPage(Integer pageNo, Integer pageSize);
    Map queryUsersByPage(User user, Integer pageNo, Integer pageSize);
    Integer saveUser(User user);
}
