package com.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Integer divisionId;
    @Column
    private String name;

    @JsonBackReference
    @OneToMany(targetEntity = Employee.class, mappedBy = "division")
    private List< Employee > employeeList;

    public Division() {
    }

    public Division(Integer divisionId, String name, List<Employee> employeeList) {
        this.divisionId = divisionId;
        this.name = name;
        this.employeeList = employeeList;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
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
