package com.blog_app.blog_app_restful.service.impl;

import com.blog_app.blog_app_restful.model.Blog;
import com.blog_app.blog_app_restful.repository.IBlogRepository;
import com.blog_app.blog_app_restful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "blogService")
public class BlogService implements IBlogService {
    @Autowired
    @Qualifier(value = "iBlogRepository")
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> getAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByName(String name) {
        return iBlogRepository.getByName("%" + name + "%");
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable of) {
        return iBlogRepository.findAll(of);
    }
}
