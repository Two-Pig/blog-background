package com.example.blog.serviceImpl;

import com.example.blog.entity.Tag;
import com.example.blog.mapper.TagMapper;
import com.example.blog.service.TagService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;

    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public Map queryTagsByPage(Integer pageNo, Integer pageSize) {
        return queryTagsByPage(null, pageNo, pageSize);
    }

    @Override
    public Map queryTagsByPage(Tag tag, Integer pageNo, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<List> list = tagMapper.pageQuery(tag, pageNo, pageSize);
        List<Tag> tags=(List<Tag>) list.get(0);
        int totalNum=(int)list.get(1).get(0);
        map.put("tags", tags);
        map.put("totalNum", totalNum);
        return map;
    }

    @Override
    public List<Tag> queryTagsByBlogId(int blogId) {
        return null;
    }

    @Override
    public Integer saveTag(Tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public Integer deleteTagByIds(int[] ids) {
        return tagMapper.deleteByIds(ids);
    }
}
