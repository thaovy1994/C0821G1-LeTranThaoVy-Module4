package com.case_study.controller;

import com.case_study.model.employee.Employee;
import com.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

//    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Employee>> showList(@RequestParam(name = "name", required = false) String name,
//                                                   @RequestParam(name = "index", required = false) int index) {
//        List<Employee> employeeListList = employeeService.findByName(name);
//        return new ResponseEntity<>(employeeListList, HttpStatus.OK);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees = this.employeeService.getAll();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<Employee> getById(@RequestParam(name="id")Integer id){
        return new ResponseEntity<>(employeeService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>("successfully",HttpStatus.OK);
    }

//    @GetMapping(value = "/employee/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id){
//        return new ResponseEntity<>(employeeService.remove(id),HttpStatus.OK);
//    }
}
