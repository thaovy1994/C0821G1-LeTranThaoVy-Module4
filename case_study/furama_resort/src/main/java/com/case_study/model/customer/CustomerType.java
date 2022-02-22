package com.case_study.model.customer;

import com.case_study.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customerType")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerType_id")
    private Integer customerTypeId;
    @Column
    private String name;

    @JsonBackReference
    @OneToMany(targetEntity = Customer.class, mappedBy = "customerType", cascade = CascadeType.ALL)
    private List< Customer > customerList;

    public CustomerType() {
    }

    public CustomerType(Integer customerTypeId, String name, List<Customer> customerList) {
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.customerList = customerList;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
