package com.service;

import com.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> showAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);
}
