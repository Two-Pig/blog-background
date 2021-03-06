package com.example.blog.serviceImpl;

import com.example.blog.entity.BlogTag;
import com.example.blog.mapper.BlogTagMapper;
import com.example.blog.service.BlogTagService;
import org.springframework.stereotype.Service;

@Service
public class BlogTagServiceImpl implements BlogTagService {
    private final BlogTagMapper blogTagMapper;

    public BlogTagServiceImpl(BlogTagMapper blogTagMapper) {
        this.blogTagMapper = blogTagMapper;
    }

    @Override
    public int update(int blogId, int tagId) {
        if (blogTagMapper.queryByTagIdAndBlogId(tagId, blogId) > 0) {
            BlogTag blogTag = new BlogTag(null, blogId, tagId);
            return blogTagMapper.insert(blogTag);
        }
        return 0;
    }
}
