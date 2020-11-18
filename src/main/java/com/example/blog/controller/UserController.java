package com.example.blog.controller;

import com.example.blog.config.ResultConfig.Result;
import com.example.blog.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/queryUsers")
    public Result queryAllUser(Integer pageNo, Integer pageSize) {
        Map map = userService.queryUserByPage(pageNo, pageSize);
        return Result.success(map);
    }
}
