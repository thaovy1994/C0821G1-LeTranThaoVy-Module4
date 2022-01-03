package com.blog_app.blog_app_restful.controller;

import com.blog_app.blog_app_restful.model.Category;
import com.blog_app.blog_app_restful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class BlogRestController {
    @Autowired
    private ICategoryService categoryService;
    public ResponseEntity <List<Category>> categoriseList() {
        List<Category> categoriseList = (List<Category>)categoryService.getAll();
        if(categoriseList.size() ==0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoriseList,HttpStatus.OK);
    }
}
