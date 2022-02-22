package com.case_study.service.impl;

import com.case_study.dto.EmployeeDto;
import com.case_study.model.employee.Employee;
import com.case_study.repository.employee.IEmployeeRepository;
import com.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "employeeService")
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> findByName(Pageable pageable, String name) {
        Page<Employee> employeePage = employeeRepository.getByName(pageable,"%"+name+"%");
        return employeePage;
    }

//    @Override
//    public List<Employee> findByName(String name) {
//        return findByName("%" + name + "%");
//    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void save(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getEmployeeId(),employeeDto.getName(),employeeDto.getBirthDay(),
                employeeDto.getIdCard(),employeeDto.getSalary(),employeeDto.getPhone(),employeeDto.getEmail(),
                employeeDto.getAddress(),employeeDto.getPosition(),employeeDto.getDegree(),employeeDto.getDivision());
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable of) {
        return employeeRepository.findAll(of);
    }
}
