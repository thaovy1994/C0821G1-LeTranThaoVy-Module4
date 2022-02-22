package com.case_study.controller;

import com.case_study.dto.CustomerDto;
import com.case_study.model.customer.Customer;
import com.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = this.customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<Customer> getById(@RequestParam(name = "id") Integer id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody CustomerDto customerDto) {
        customerService.save(customerDto);
        return new ResponseEntity<>("successfully", HttpStatus.OK);
    }
}
