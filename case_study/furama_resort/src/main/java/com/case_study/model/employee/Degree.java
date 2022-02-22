package com.case_study.model.employee;

import com.case_study.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "degree_id")
    private Integer degreeId;
    @Column
    private String name;

    @JsonBackReference
    @OneToMany(targetEntity = Employee.class, mappedBy = "degree", cascade = CascadeType.ALL)
    private List< Employee > employeeList;

    public Degree() {
    }

    public Degree(Integer degreeId, String name, List<Employee> employeeList) {
        this.degreeId = degreeId;
        this.name = name;
        this.employeeList = employeeList;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
