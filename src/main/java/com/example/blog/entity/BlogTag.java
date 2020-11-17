package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogTag {
    private Integer id;
    private Integer blogId;
    private Integer tagId;
}
