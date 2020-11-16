package com.example.blog.serviceImpl;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Tag;
import com.example.blog.mapper.BlogMapper;
import com.example.blog.mapper.TagMapper;
import com.example.blog.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogMapper blogMapper;

    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public Map queryBlogsByPage(Integer pageNo, Integer pageSize) {
        return queryBlogsByPage(null, pageNo, pageSize);
    }

    @Override
    public Map queryBlogsByPage(Blog blog, Integer pageNo, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<List> list = blogMapper.pageQuery(blog, pageNo, pageSize);
        System.out.println(list);
        List<Blog> blogs=(List<Blog>) list.get(0);
        int totalNum=(int) list.get(1).get(0);
        map.put("blogs", blogs);
        map.put("totalNum", totalNum);
        return map;
    }

    @Override
    public Map queryBlogsByTypeAndTag(int flagId,int tagId, Integer pageNo, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
//        List<Blog> blogs = blogMapper.pageQuery(blog, pageNo, pageSize);
//        Integer totalNum = blogMapper.queryTotalNum(blog);
//        map.put("blogs", blogs);
//        map.put("totalNum", totalNum);
        return map;
    }

    @Override
    public Integer saveBlog(Blog blog) {
        return blogMapper.insert(blog);
    }

    @Override
    public Integer deleteBlogByIds(int[] ids) {
        return blogMapper.deleteByIds(ids);
    }
}
