package com.controller;

import com.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalFormController {
    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("medicalDeclaration" , new MedicalDeclaration());
        String [] nationals = {"Vietnamese", "Japanese", "English", "Korea"};
        model.addAttribute("nationals",nationals);
        String [] cities = {"Da Nang", "Ha Noi", "Ho Chi Minh", "Hue"};
        model.addAttribute("cities",cities);
        String [] districts = {"1", "2", "3", "4"};
        model.addAttribute("districts",districts);
        String [] wards = {"1", "2", "3"};
        model.addAttribute("wards",wards);
        String [] choices ={"Yes", "No"};
        model.addAttribute("choices",choices);
        return "form";
    }
    @PostMapping("/showInfo")
    public ModelAndView showInfo(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration){
        ModelAndView modelAndView = new ModelAndView("show",
                "medicalDeclaration", medicalDeclaration);
        System.out.println(medicalDeclaration.toString());
        return modelAndView;
    }
}
