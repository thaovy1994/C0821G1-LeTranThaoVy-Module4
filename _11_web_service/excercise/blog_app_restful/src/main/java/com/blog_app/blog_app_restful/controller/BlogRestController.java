package com.blog_app.blog_app_restful.controller;

import com.blog_app.blog_app_restful.model.Blog;
import com.blog_app.blog_app_restful.dto.BlogDto;
import com.blog_app.blog_app_restful.model.Category;
import com.blog_app.blog_app_restful.service.IBlogService;
import com.blog_app.blog_app_restful.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/blogRest")
public class BlogRestController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "/list-category")
    public ResponseEntity<List<Category>> categoryList() {
        List<Category> categoryList = categoryService.getAll();
        if (categoryList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 2) Pageable pageable) {
        //Lấy ra danh sách Blog
        Page<Blog> blogPage = this.blogService.getAll(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerBlog(@RequestBody @Valid BlogDto blogDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        //copy blogDto to blogObject
        Blog blogObj = new Blog();
        BeanUtils.copyProperties(blogDto, blogObj);
        //save to DB
        blogService.save(blogObj);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
