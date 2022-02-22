package com.case_study.service.impl;

import com.case_study.dto.CustomerDto;
import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.repository.customer.ICustomerRepository;
import com.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerService")
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name) {
        Page<Customer> customerPage = customerRepository.getByName(pageable, "%" + name + "%");
        return customerPage;
    }

    @Override
    public void save(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getCustomerId(), customerDto.getFirstName(), customerDto.getLastName(),
                customerDto.getDateOfBirth(), customerDto.getGender(), customerDto.getPhone(),
                customerDto.getEmail(), customerDto.getAddress(), customerDto.getCustomerType());
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable of) {
        return customerRepository.findAll(of);
    }
}
