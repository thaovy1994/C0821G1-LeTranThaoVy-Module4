package com.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;
    @Column
    private String name;

    @JsonBackReference
    @OneToMany(targetEntity = Employee.class, mappedBy = "position")
    private List< Employee > employeeList;

    public Position() {
    }

    public Position(Integer positionId, String name, List<Employee> employeeList) {
        this.positionId = positionId;
        this.name = name;
        this.employeeList = employeeList;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
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
