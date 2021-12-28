package com.user_registration_form.controller;

import com.user_registration_form.dto.UserDTO;
import com.user_registration_form.model.User;
import com.user_registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public ModelAndView listPage() {
        return new ModelAndView("list_user", "userList", userService.getAll());
    }

    @GetMapping("/create_user")
    public String showCreateForm(Model model) {
        model.addAttribute("users", new UserDTO());
        return "create_user";
    }

    @PostMapping(value = "/create_user")
    //Lưu ý: BindingResult luôn đứng ngay sau ModelAttribute -> hứng obj DTO
    //nếu 1 trang create 2 obj -> 2 ModelAttribute sẽ có 2 BindingResult để hứng
    public String createNewBlog(@Valid @ModelAttribute("users") UserDTO userDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        //gọi method validate() đê check
        new UserDTO().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "create_user";
        }
        userService.save(userDto);
        redirectAttributes.addFlashAttribute("userList", userService.getAll());
        redirectAttributes.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/list";
    }
}
