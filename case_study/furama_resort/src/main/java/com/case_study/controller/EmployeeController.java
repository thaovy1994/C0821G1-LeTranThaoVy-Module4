package com.case_study.controller;

import com.case_study.model.Employee;
import com.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    @Qualifier(value = "employeeService")
    private IEmployeeService employeeService;

    @GetMapping("/list_employee")
    public ModelAndView listPage() {
        return new ModelAndView("list_employee", "employeeList", employeeService.getAll());
    }

    @GetMapping("{id}")
    public String showEditForm(@PathVariable(name = "id") Integer id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/list_employee")
    public ModelAndView updateCustomer(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("list_employee");
        modelAndView.addObject("employeeList", employeeService.getAll());
        modelAndView.addObject("message", "Updated successfully");
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", employeeService.getAll());
        model.addAttribute("employee", new Employee());
        return "create_employee";
    }

    @PostMapping(value = "/create-employee")
    public String createNewEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes
            , HttpServletResponse response, @CookieValue(value = "cookieCount", defaultValue = "0") int newCookie) {
        employeeService.save(employee);
//        Cookie cookie = new Cookie("cookieCount", String.valueOf(newCookie + 1));
//        cookie.setPath("/");
//        cookie.setHttpOnly(false);
//        cookie.setMaxAge(24 * 60 * 60);
//        response.addCookie(cookie);
        redirectAttributes.addFlashAttribute("employeeList", employeeService.getAll());
        redirectAttributes.addFlashAttribute("message", "Create new employee successfully!");
        return "redirect:/list_employee";
    }
}
