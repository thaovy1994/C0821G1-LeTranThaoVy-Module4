package com.case_study.controller;

import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.service.ICustomerService;
import com.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    @Qualifier(value = "customerService")
    private ICustomerService customerService;

    @Autowired
    @Qualifier(value = "customerTypeService")
    private ICustomerTypeService customerTypeService;

    @GetMapping(value = "/list-page")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("customerId").ascending();
        Page<Customer> customerPage = customerService.findAll(PageRequest.of(page, 4, sort));
        model.addAttribute("customerPage", customerPage);
        return "customer/list";
    }
}
