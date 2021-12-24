package com.blog_app.blog_application_extend.controller;

import com.blog_app.blog_application_extend.model.Blog;
import com.blog_app.blog_application_extend.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

//    @GetMapping(value = {"/list",""})
//    Hoặc
    @GetMapping("/blog")
    public ModelAndView listPage() {
        return new ModelAndView("/list","blogList", blogService.getAll());
    }

//    @GetMapping(value = {"/list", ""})
//    public ModelAndView listPage(@RequestParam(value = "id", defaultValue = "")Integer id) {
//        return new ModelAndView("list","students", blogService.findById(id));
//    }

    @GetMapping("/create-blog")
    public String showCreateForm(Model model) {
        model.addAttribute("blog",new Blog());
        return "create-blog";
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create-blog");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = (Blog) blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:blog";
    }

    //    @GetMapping(value = "list-page")
//    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
//        Sort sort = Sort.by("name").descending();
//        Page<Student> studentPage = iStudentService.findAll(PageRequest.of(page,5,sort));
//        model.addAttribute("studentPage", studentPage);
//        return "student/list_page";
//    }
}

