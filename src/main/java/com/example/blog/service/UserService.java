package com.example.blog.service;

import com.example.blog.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    List<User> queryAllUser();
    String login(User user, HttpSession session);
}
