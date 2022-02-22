package com.case_study.controller;

import com.case_study.dto.EmployeeDto;
import com.case_study.model.employee.Employee;
import com.case_study.service.IDegreeService;
import com.case_study.service.IDivisionService;
import com.case_study.service.IEmployeeService;
import com.case_study.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    @Qualifier(value = "employeeService")
    private IEmployeeService employeeService;

    @Autowired
    @Qualifier(value = "positionService")
    private IPositionService positionService;

    @Autowired
    @Qualifier(value = "degreeService")
    private IDegreeService degreeService;

    @Autowired
    @Qualifier(value = "divisionService")
    private IDivisionService divisionService;

//    @GetMapping("/list-employee")
//    public ModelAndView listPage() {
//        return new ModelAndView("list_employee", "employeeList", employeeService.getAll());
//    }

    @GetMapping(value = "/list-page")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("employeeId").ascending();
        Page<Employee> employeePage = employeeService.findAll(PageRequest.of(page, 4, sort));
        model.addAttribute("employeePage", employeePage);
        return "employee/list_page";
    }

    @GetMapping("/search")
    public String searchEmployee(@RequestParam(name = "name")String name,Pageable pageable,Model model) {
        Page<Employee> employeePage = employeeService.findByName(pageable,name);
        model.addAttribute("employeePage", employeePage);
        return "employee/list_page";
    }

    @GetMapping("/create-employee")
    public String showCreateForm(Model model) {
        model.addAttribute("position", positionService.getAll());
        model.addAttribute("division", divisionService.getAll());
        model.addAttribute("degree", degreeService.getAll());
        model.addAttribute("employee", new Employee());
        return "employee/create_employee";
    }

    @PostMapping(value = "/create-employee")
    public String createNewEmployee(Model model,@Valid @ModelAttribute("employee") EmployeeDto employeeDto,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes
            , HttpServletResponse response, @CookieValue(value = "cookieCount", defaultValue = "0") int newCookie) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("position", positionService.getAll());
            model.addAttribute("division", divisionService.getAll());
            model.addAttribute("degree", degreeService.getAll());
            return "employee/create_employee";
        }
        employeeService.save(employeeDto);
//        Cookie cookie = new Cookie("cookieCount", String.valueOf(newCookie + 1));
//        cookie.setPath("/");
//        cookie.setHttpOnly(false);
//        cookie.setMaxAge(24 * 60 * 60);
//        response.addCookie(cookie);
        redirectAttributes.addFlashAttribute("employeePage", employeeService.getAll());
        redirectAttributes.addFlashAttribute("message", "Create new employee successfully!");
        return "redirect:/employee/list-page";
    }

//    @GetMapping(value = "{id}/detail")
//    public String getDetail(@PathVariable(name = "id") Integer id, Model model,
//                            RedirectAttributes redirectAttributes) {
//        Employee employee = employeeService.findById(id);
//        model.addAttribute("employee",employee);
//        return "redirect:/employee/list-page";
//    }

    @GetMapping("/edit-employee/{id}")
    public String showEditForm(@PathVariable(name = "id") Integer id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("position", positionService.getAll());
        model.addAttribute("division", divisionService.getAll());
        model.addAttribute("degree", degreeService.getAll());
        model.addAttribute("employee", employee);
        return "employee/edit_employee";
    }

    @PostMapping("/edit-employee")
    public String editEmployee(Model model,@Valid @ModelAttribute("employee") EmployeeDto employeeDto,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes
            , HttpServletResponse response, @CookieValue(value = "cookieCount", defaultValue = "0") int newCookie) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("position", positionService.getAll());
            model.addAttribute("division", divisionService.getAll());
            model.addAttribute("degree", degreeService.getAll());
            return "employee/edit_employee";
        }
        employeeService.save(employeeDto);
        redirectAttributes.addFlashAttribute("employeePage", employeeService.getAll());
        redirectAttributes.addFlashAttribute("message", "Update successfully!");
        return "redirect:/employee/list-page";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam(name = "id") Integer id) {
        Employee employee = employeeService.findById(id);
        employeeService.remove(employee.getEmployeeId());
//        employeeService.remove(id);
        return "redirect:/employee/list-page";
    }
}
