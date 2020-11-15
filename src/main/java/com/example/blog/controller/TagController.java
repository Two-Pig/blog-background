package com.example.blog.controller;

import com.example.blog.config.ResultConfig.Result;
import com.example.blog.config.ResultConfig.ResultEnum;
import com.example.blog.entity.Tag;
import com.example.blog.entity.Type;
import com.example.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/queryTags")
    public Result queryTags(Integer pageNo, Integer pageSize) {
        Map map = tagService.queryTagsByPage(pageNo, pageSize);
        return Result.success(map);
    }

    @PostMapping("/addTag")
    public Result addTag(@RequestBody Tag tag) {
        Integer result = tagService.saveTag(tag);
        if (result > 0) {
            return Result.success();
        }
        return Result.error(ResultEnum.UNKNOW_ERROR);
    }

    @DeleteMapping("/deleteTag")
    /**
     * 也可以用 List<int> 接受数组
     */
    public Result deleteTag(@RequestBody int[] ids) {
        tagService.deleteTagByIds(ids);
        return Result.success();
    }

}
