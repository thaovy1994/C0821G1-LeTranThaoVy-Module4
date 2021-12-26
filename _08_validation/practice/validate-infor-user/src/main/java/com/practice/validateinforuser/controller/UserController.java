package com.practice.validateinforuser.controller;

import com.practice.validateinforuser.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    //Thêm @Validated @ModelAttribute("user") User user để xác thực Model User
    //BindingResult bindingResult giữ kết quả xác nhận và ràng buộc User có xảy ra lỗi không.
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/index");
        }
        return new ModelAndView("/result");
    }
}
