package com.blog_app.controller;

import com.blog_app.model.Blog;
import com.blog_app.service.IBlogService;
import com.blog_app.service.ICategoryService;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("blogTalkList")
public class BlogController {

    //khởi tạo giá trị ban đầu cho sesion trên = cách tạo @ModelAttribute bên ngoài các method
    //Khi để @ModelAttribute bên ngoài method như này -> truy cập Controller nó sẽ chạy method này
    //và khởi tạo giá trị ban đầu cho session là 1 arrayList rỗng
    //vì vậy sau đó truye cấp vào /talk-list nó mới hiển thị đc
    @ModelAttribute("blogTalkList")
    public List<Blog> createBlogTalkList() {
        return new ArrayList<>();
    }

    @Autowired
    @Qualifier(value = "blogService")
    private IBlogService blogService;
    @Autowired
    @Qualifier(value = "categoryService")
    private ICategoryService categoryService;

    //để add blogs vào 1 room nói chuyện, thêm tham số id để bjt add obj nào vào TalkList
    @GetMapping("/addTalkList/{id}")
    public String addTalkList(@PathVariable("id") Integer id, @ModelAttribute("blogTalkList") List<Blog> blogList
            , RedirectAttributes redirectAttributes) {
        //tìm obj blog dựa vào id
        Blog blog = blogService.findById(id);
        blogList.add(blog);
        redirectAttributes.addFlashAttribute("msg", "Add talk list successfully");
        return "redirect:/list-blog";
    }

    @GetMapping("/blog")
    public ModelAndView listPage() {
        return new ModelAndView("list-blog", "blogList", blogService.getAll());
    }

    @GetMapping("/create-blog")
    public String showCreateForm(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("blog", new Blog());
        return "create-blog";
    }

    @PostMapping(value = "/create-blog")
    //Nếu tạo thêm 1 ng -> value tắng lên 1, nhưng value đang set cứng => cần lấy value cũ + 1
    //Cập nhật cookie đúng theo số ng ta tạo = cách lấy cookie.
    //lấy cookie = @CookieValue
    //defaultValue giúp tránh lỗi -> trong case ko exist cookie này ( ... for method type int is not present)
    public String createNewBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes
            , HttpServletResponse response, @CookieValue(value = "cookieCount", defaultValue = "0") int newCookie) {
        blogService.save(blog);
        //Sau khi tạo obj thành công, ta tạo cookie = cách:
        //tạo lần đầu tiên value = 1
//        Cookie cookie = new Cookie("cookieCount", "1");
        Cookie cookie = new Cookie("cookieCount", String.valueOf(newCookie + 1));
        //or
        //Cookie cookie = new Cookie("cookieCount", newCookie + 1 + ""));
        //Để áp dụng cookie cho all đường dẫn trong trang web -> sử dụng thêm method setPath
        cookie.setPath("/");
        cookie.setHttpOnly(false);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);     //public cookie ra đường dẫn khác trong application mà ko cần url của @RequestMapping
        redirectAttributes.addFlashAttribute("blogList", blogService.getAll());
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully!");
//        return "redirect:/blog";
        return "redirect:/list_page";
    }

    //Dùng ModelAndView or Model -> Nếu load lại trang sẽ tiếp tục tạo obj vừa mới thêm.
//    @PostMapping("/create-blog")
//    public ModelAndView createNewBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("blogList", blogService.getAll());
//        modelAndView.addObject("message", "New blog created successfully");
//        return modelAndView;
//    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam(name = "name") String name, Model model) {
        List<Blog> blogList = blogService.findByName(name);
        model.addAttribute("blogList", blogList);
        return "list-blog";
    }

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

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable(name = "id") Integer id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete-blog");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

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

    @ExceptionHandler(Exception.class)
    public String handleException() {
        System.out.println("err");
        return "error";
    }
}

