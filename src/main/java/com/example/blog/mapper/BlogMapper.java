package com.example.blog.mapper;

import com.example.blog.entity.Blog;

import java.util.List;
public interface BlogMapper extends TemplateMapper<Blog>{
    List<Blog> pageQueryByType(Blog entity, Integer pageNo, Integer pageSize);
    List<Blog> pageQueryByTypeAndTag(Integer typeId,Integer tagId, Integer pageNo, Integer pageSize);
}
