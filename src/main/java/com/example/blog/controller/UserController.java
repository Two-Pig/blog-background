package com.example.blog.controller;

import com.example.blog.config.ResultConfig.Result;
import com.example.blog.entity.Type;
import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        Integer result = userService.saveUser(user);
        return Result.success();
    }
}
