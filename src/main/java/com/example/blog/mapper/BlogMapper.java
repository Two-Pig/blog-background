package com.example.blog.mapper;

import com.example.blog.entity.Blog;

import java.util.List;
public interface BlogMapper extends TemplateMapper<Blog>{
    List<List> pageQueryByType(Blog entity, Integer pageNo, Integer pageSize);
    List<List> pageQueryByTypeAndTag(Integer typeId,Integer tagId, Integer pageNo, Integer pageSize);
}
