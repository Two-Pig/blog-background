package com.example.blog.mapper;

import com.example.blog.entity.Tag;

import java.util.List;

public interface TagMapper extends TemplateMapper<Tag>{
    List<Tag> queryTagsByBlogId(int blogId);
}
