package com.practice_lesson_11.controller;

import com.practice_lesson_11.model.Customer;
import com.practice_lesson_11.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customerRest")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Customer>> getPageCustomer(@PageableDefault(value = 2) Pageable pageable) {
        Page<Customer> customerPage = this.customerService.findAll(pageable);
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }
}
