package com.blog_app.blog_app_restful.controller;

import com.blog_app.model.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class BlogTalkController {
    //method lấy sesion và hiển thị cho user
    @GetMapping("/talk-list")
    public String viewTalkList(@SessionAttribute("blogTalkList") List<Blog> blogList, Model model){
        model.addAttribute("blogTalkList",blogList);
        return "talk-list";
    }
}
