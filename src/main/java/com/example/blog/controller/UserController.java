package com.example.blog.controller;

import com.example.blog.config.ResultConfig.Result;
import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/queryAllUser")
    public Result queryAllUser(String a, String b) {
        List<User> users = userService.queryAllUser();
        return Result.success(users);
    }
}
