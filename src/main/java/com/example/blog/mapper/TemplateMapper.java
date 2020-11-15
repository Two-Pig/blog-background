package com.example.blog.mapper;

import com.example.blog.entity.Type;

import java.util.List;

/**
 * 通用的增删改查模板
 */
public interface TemplateMapper<T> {
    List<T> pageQuery(T entity,Integer pageNo,Integer pageSize);
    Integer queryTotalNum(T entity);
    Integer insert(T entity);
    Integer update(T entity);
    Integer delete(T entity);
}
