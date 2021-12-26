package com.blog_app.blog_application_extend.controller;

import com.blog_app.blog_application_extend.model.Blog;
import com.blog_app.blog_application_extend.service.IBlogService;
import com.blog_app.blog_application_extend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    @Qualifier(value = "blogService")
    private IBlogService blogService;
    @Autowired
    @Qualifier(value = "categoryService")
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public ModelAndView listPage() {
        return new ModelAndView("list-blog", "blogList", blogService.getAll());
    }

    @GetMapping("/create-blog")
    public String showCreateForm(Model model) {
        model.addAttribute("categories",categoryService.getAll());
        model.addAttribute("blog", new Blog());
        return "create-blog";
    }

    //Cách này -> Nếu load lại trang sẽ tiếp tục tạo obj vừa thêm.
//    @PostMapping("/create-blog")
//    public ModelAndView createNewBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("blogList", blogService.getAll());
//        modelAndView.addObject("message", "New blog created successfully");
//        return modelAndView;
//    }

    @PostMapping(value = "/create-blog")
    public String createNewBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("blogList", blogService.getAll());
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully!");
//        return "redirect:/blog";
        return "redirect:/list_page";
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam(name = "name") String name, Model model) {
        List<Blog> blogList = blogService.findByName(name);
        model.addAttribute("blogList", blogList);
        return "list-blog";
    }

    //NOT YET
    @GetMapping("/edit-blog/{id}")
    public String showEditForm(@PathVariable(name = "id") Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "edit-blog";
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("list-blog");
        modelAndView.addObject("blogList", blogService.getAll());
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    //NOT YET
    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable(name = "id") Integer id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    //NOT YET
    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:/blog";
    }

    @GetMapping(value = "/list_page")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        //sắp xếp theo tên cột trong DB
        Sort sort = Sort.by("id").ascending();
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page, 4, sort));
        model.addAttribute("listPage", blogPage);
        return "list-page";
    }
}

