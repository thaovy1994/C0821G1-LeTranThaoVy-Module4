package com.blog_app.blog_application_extend.service.impl;

import com.blog_app.blog_application_extend.model.Category;
import com.blog_app.blog_application_extend.repository.ICategoryRepository;
import com.blog_app.blog_application_extend.service.ICategoryService;
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
