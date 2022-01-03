package com.blog_app.blog_app_restful.service;

import com.blog_app.blog_app_restful.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    void save(Blog blog);

    void remove(Integer id);

    Blog findById(Integer id);

    List<Blog> getAll();

    Page<Blog> getAll(Pageable pageable);

    List<Blog> findByName(String name);

    Page<Blog> findAllByName(Pageable pageable, String keyword);

    Page<Blog> findAll(Pageable of);
}