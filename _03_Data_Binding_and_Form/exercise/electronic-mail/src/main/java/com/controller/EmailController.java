package com.controller;

import com.model.Email;
import com.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping(value = "create")
    public String goPageCreate(Model model) {
        String[] language = {"English", "Vietnamese", "Japanese", "Chinese"};
        String[] size = {"5", "10", "15", "25", "50", "100"};
        String[] spams = {"enable"};
        model.addAttribute("language", language);
        model.addAttribute("size", size);
        model.addAttribute("spams", spams);
        model.addAttribute("email", new Email());
        return "create";
    }

    @GetMapping(value = "index")
    public String index(Model model) {
        model.addAttribute("email",emailService.show());
        return "index";
    }

    @PostMapping(value = "create")
    public String createEmail(@ModelAttribute("email") Email email, RedirectAttributes redirectAttributes) {
        emailService.create(email);
        redirectAttributes.addFlashAttribute("msg", "Success");
        redirectAttributes.addFlashAttribute("email", emailService.show());
        return "redirect: /index";
    }
}
