package com.case_study.controller;

import com.case_study.model.Employee;
import com.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> showList(@RequestParam(name = "name", required = false) String name,
                                                   @RequestParam(name = "index", required = false) int index) {
        List<Employee> employeeListList = employeeService.findByName(name);
        return new ResponseEntity<>(employeeListList, HttpStatus.OK);
    }
}
