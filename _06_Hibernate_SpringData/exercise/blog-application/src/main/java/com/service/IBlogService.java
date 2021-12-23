package com.service;

import com.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> showAll();

    Blog findById(Integer id);

    List<Blog> findByName(String name);

    void save(Blog blog);

    void remove(Integer id);
}
