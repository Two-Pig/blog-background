package com.example.blog.service;

import com.example.blog.entity.Tag;

import java.util.List;
import java.util.Map;

public interface TagService {
    Map queryTagsByPage(Integer pageNo, Integer pageSize);
    Map queryTagsByPage(Tag tag, Integer pageNo, Integer pageSize);
    List<Tag> queryTagsByBlogId(int blogId);
    Integer saveTag(Tag tag);
    Integer deleteTagByIds(int[] ids);
}
