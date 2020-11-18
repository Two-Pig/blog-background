package com.example.blog.service;

import com.example.blog.entity.Type;

import java.util.Map;

public interface TypeService {
    Map queryTypesByPage(Integer pageNo, Integer pageSize);
    Map queryTypesByPage(Type type,Integer pageNo, Integer pageSize);
    Integer saveType(Type type);
    Integer deleteTypeByIds(int[] ids);
}
