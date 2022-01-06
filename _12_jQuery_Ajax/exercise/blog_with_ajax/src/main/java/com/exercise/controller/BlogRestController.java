package com.exercise.controller;

import com.exercise.model.Blog;
import com.exercise.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Blog>> showList(@RequestParam(name = "nameBlog", required = false) String name,
                                               @RequestParam(name = "index", required = false) int index) {
        List<Blog> blogList = blogService.searchByName(name, index);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
