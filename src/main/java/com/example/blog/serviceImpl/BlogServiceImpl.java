package com.example.blog.serviceImpl;

import com.example.blog.entity.Blog;
import com.example.blog.mapper.BlogMapper;
import com.example.blog.mapper.BlogTagMapper;
import com.example.blog.mapper.TagMapper;
import com.example.blog.service.BlogService;
import com.example.blog.service.BlogTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogMapper blogMapper;

    private final TagMapper tagMapper;

    private final BlogTagService blogTagService;

    private final BlogTagMapper blogTagMapper;

    public BlogServiceImpl(BlogTagService blogTagService, TagMapper tagMapper, BlogMapper blogMapper, BlogTagMapper blogTagMapper) {
        this.blogMapper = blogMapper;
        this.tagMapper = tagMapper;
        this.blogTagService = blogTagService;
        this.blogTagMapper = blogTagMapper;
    }

    @Override
    public Map queryBlogsByPage(Integer pageNo, Integer pageSize) {
        return queryBlogsByPage(null, pageNo, pageSize);
    }

    @Override
    public Map queryBlogsByPage(Blog blog, Integer pageNo, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<List> list = blogMapper.pageQuery(blog, pageNo, pageSize);
        return getMap(map, list);
    }

    @Override
    public Map queryBlogsByTypeAndTag(Integer typeId, Integer tagId, Integer pageNo, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<List> list = blogMapper.pageQueryByTypeAndTag(typeId, tagId, pageNo, pageSize);
        return getMap(map, list);
    }

    private Map getMap(HashMap<String, Object> map, List<List> list) {
        List<Blog> blogs = (List<Blog>) list.get(0);
        int totalNum = (int) list.get(1).get(0);
        map.put("blogs", blogs);
        map.put("totalNum", totalNum);
        return map;
    }

    @Transactional
    @Override
    public Blog queryOneBlogById(int blogId) {
        Blog blog = blogMapper.queryOneById(blogId);
        blog.setTags(tagMapper.queryTagsByBlogId(blogId));
        return blog;
    }

    @Override
    public Integer saveBlog(Blog blog) {
        return blogMapper.insert(blog);
    }

    @Override
    public Integer updateBlog(Blog blog) {
        List<Integer> tags = blog.getTags();
        tags.forEach(tag -> {
            blogTagService.update(tag, blog.getId());
        });
        return blogMapper.update(blog);
    }

    @Transactional
    @Override
    public Integer deleteBlogByIds(int[] ids) {
        for (int id : ids) {
            blogTagMapper.deleteBlogTagByBlogId(id);
        }
        return blogMapper.deleteByIds(ids);
    }
}
