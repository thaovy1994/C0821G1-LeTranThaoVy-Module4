package com.case_study.service;

import com.case_study.dto.CustomerDto;
import com.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();

    Customer findById(Integer id);

    Page<Customer> findByName(Pageable pageable, String name);

    void save(Customer customer);

    void save(CustomerDto customerDto);

    void remove(Integer id);

    Page<Customer> findAll(Pageable of);
}
