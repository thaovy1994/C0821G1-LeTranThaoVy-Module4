package com.exercise.service;

import com.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void deleteById(Integer id);
    Blog findById (Integer id);
    List<Blog> searchByName(String name, int offset);
}
