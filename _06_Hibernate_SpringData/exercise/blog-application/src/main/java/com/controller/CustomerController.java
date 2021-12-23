package com.controller;

import com.model.Blog;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RequestMapping("/blog")
@Controller
public class CustomerController {
    @Autowired
    @Qualifier("blogService")
    private IBlogService blogService;

//    @GetMapping("/create")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/blog/create");
//        modelAndView.addObject("blog", new Blog());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("/blog/create");
//        modelAndView.addObject("blog", new Blog());
//        modelAndView.addObject("message", "New blog created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("search")
//    public String searchBlog(@RequestParam(name = "name") String name, Model model) {
//        List<Blog> blogList = blogService.findByName(name);
//        model.addAttribute("blogList",blogList);
//        return "blog/list";
//    }

//    @GetMapping(value = {"/list", ""})
//    public ModelAndView listPage(@RequestParam(value = "name", defaultValue = "")String name) {
//        return new ModelAndView("student/list_student","students", blogService.findByName(name));
//    }

    @GetMapping("blog/list")
    public ModelAndView listCustomers() {
        List<Blog> blogList = blogService.showAll();
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable Integer id) {
//        Blog blog = (Blog) blogService.findById(id);
//        if (blog != null) {
//            ModelAndView modelAndView = new ModelAndView("/blog/edit");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit")
//    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("/blog/edit");
//        modelAndView.addObject("blog", blog);
//        modelAndView.addObject("message", "Blog updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Integer id) {
//        Blog blog = blogService.findById(id);
//        if (blog != null) {
//            ModelAndView modelAndView = new ModelAndView("/blog/delete");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete")
//    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
//        blogService.remove(blog.getId());
//        return "redirect:blog";
//    }
}
