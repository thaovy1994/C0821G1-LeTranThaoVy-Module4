package com.case_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class HomeController {
    @GetMapping(value = "/home")
    public String showHome() {
        return "home";
    }
}
