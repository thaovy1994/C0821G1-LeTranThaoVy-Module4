package com.blog_app.service.impl;

import com.blog_app.model.Category;
import com.blog_app.repository.ICategoryRepository;
import com.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "categoryService")
public class CategoryService implements ICategoryService {

    @Autowired
    @Qualifier(value = "iCategoryRepository")
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAll() {
        return iCategoryRepository.findAll();
    }
}
