package com.service.impl;

import com.model.Blog;
import com.repository.IBlogRepository;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "blogService")
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> showAll() {
        return repository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByName(String name) {
        return repository.getByName("%"+name+"%");
    }

    @Override
    public void save(Blog blog) {
        //nếu có id -> sẽ update, nếu ko có id -> sẽ create new
        repository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
