package com.example.blog.controller;

import com.example.blog.config.ResultConfig.Result;
import com.example.blog.config.ResultConfig.ResultEnum;
import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BlogController {
    
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/queryBlogs")
    public Result queryBlogs(Integer pageNo, Integer pageSize) {
        Map map = blogService.queryBlogsByPage(pageNo, pageSize);
        return Result.success(map);
    }

    @PostMapping("/addBlog")
    public Result addBlog(@RequestBody Blog blog) {
        Integer result = blogService.saveBlog(blog);
        if (result > 0) {
            return Result.success();
        }
        return Result.error(ResultEnum.UNKNOW_ERROR);
    }

    @DeleteMapping("/deleteBlog")
    /**
     * 也可以用 List<int> 接受数组
     */
    public Result deleteBlog(@RequestBody int[] ids) {
        blogService.deleteBlogByIds(ids);
        return Result.success();
    }
}
