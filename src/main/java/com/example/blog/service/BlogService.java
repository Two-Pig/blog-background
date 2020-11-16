package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.Map;

public interface BlogService {
    Map queryBlogsByPage(Integer pageNo, Integer pageSize);
    Map queryBlogsByPage(Blog blog, Integer pageNo, Integer pageSize);
    Map queryBlogsByTypeAndTag(int flagId,int tagId, Integer pageNo, Integer pageSize);
    Blog queryOneBlogById(int blogId);
    Integer saveBlog(Blog blog);
    Integer updateBlog(Blog blog);
    Integer deleteBlogByIds(int[] ids);
}
