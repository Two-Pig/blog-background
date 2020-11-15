package com.example.blog.controller;

import com.example.blog.config.ResultConfig.Result;
import com.example.blog.entity.Type;
import com.example.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/queryTypes")
    public Result queryTypes(Integer pageNo, Integer pageSize) {
        Map map = typeService.queryTypesByPage(pageNo, pageSize);
        return Result.success(map);
    }
}
