package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping(" ")
    public String calculate(ModelMap model,
                            @RequestParam(name = "number1", defaultValue = "0") double number1,
                            @RequestParam(name = "number2", defaultValue = "0") double number2,
                            @RequestParam(name = "calculation", defaultValue = "") String calculation) {
        double result = 0;
        switch (calculation) {
            case "Addition(+)":
                result = number1 + number2;
                calculation = "Addition";
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                calculation = "Subtraction";
                break;
            case "Multiplication(X)":
                result = number1 * number2;
                calculation = "Multiplication";
                break;
            case "Division(/)":
                result = number1 / number2;
                calculation = "Division";
                break;
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("calcul", calculation);
        model.addAttribute("result", result);
        return "index";
    }
}
