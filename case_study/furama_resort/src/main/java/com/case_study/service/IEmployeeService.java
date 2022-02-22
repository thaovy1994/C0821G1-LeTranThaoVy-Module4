package com.case_study.service;

import com.case_study.dto.EmployeeDto;
import com.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    Employee findById(Integer id);

//    List<Employee> findByName(String name);
    Page<Employee> findByName(Pageable pageable, String name);

    void save(Employee employee);
    void save(EmployeeDto employeeDto);

    void remove(Integer id);

    Page<Employee> findAll(Pageable of);
}
