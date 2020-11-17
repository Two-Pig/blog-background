package com.example.blog.mapper;

import com.example.blog.entity.BlogTag;

public interface BlogTagMapper extends TemplateMapper<BlogTag>{
    int deleteBlogTagByBlogId(int blogId);
    int queryByTagIdAndBlogId(int tagId,int blogId);
}
