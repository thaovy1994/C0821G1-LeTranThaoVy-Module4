package com.blog_app.blog_app_restful.service;

import com.blog_app.blog_app_restful.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    Blog findById(Integer id);

    List<Blog> findByName(String name);

    void save(Blog blog);

    void remove(Integer id);

    Page<Blog> findAll(Pageable of);
}