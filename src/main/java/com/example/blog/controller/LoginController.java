package com.example.blog.controller;

import com.example.blog.config.GlobalConstant;
import com.example.blog.config.ResultConfig.Result;
import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;

@RestController
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        String token = userService.login(user, session);
        HashMap<String, Object> map = new HashMap<>();
        map.put(GlobalConstant.TOKEN_NAME, token);
        return Result.success(map);
    }

    @DeleteMapping("/logout")
    public Result logout(@RequestParam String token, HttpSession session) {
        session.removeAttribute(token);
        return Result.success();
    }
}
