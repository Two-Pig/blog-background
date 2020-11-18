package com.example.blog.controller;

import com.example.blog.config.ResultConfig.Result;
import com.example.blog.config.ResultConfig.ResultEnum;
import com.example.blog.entity.Type;
import com.example.blog.service.TypeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/type")
public class TypeController {
    private final static Logger logger=LoggerFactory.getLogger(TypeController.class);

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/queryTypes")
    public Result queryTypes(Integer pageNo, Integer pageSize) {
        Map map = typeService.queryTypesByPage(pageNo, pageSize);
        return Result.success(map);
    }

    @PostMapping("/addType")
    public Result addType(@RequestBody Type type) {
        Integer result = typeService.saveType(type);
        if (result > 0) {
            return Result.success();
        }
        return Result.error(ResultEnum.UNKNOW_ERROR);
    }

    @DeleteMapping("/deleteType")
    /**
     * 也可以用 List<int> 接受数组
     */
    public Result deleteType(@RequestBody int[] ids) {
        typeService.deleteTypeByIds(ids);
        return Result.success();
    }
}
