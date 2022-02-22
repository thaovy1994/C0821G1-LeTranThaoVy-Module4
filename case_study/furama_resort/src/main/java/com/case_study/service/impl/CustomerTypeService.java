package com.case_study.service.impl;

import com.case_study.model.customer.CustomerType;
import com.case_study.repository.customer.ICustomerTypeRepository;
import com.case_study.repository.employee.IPositionRepository;
import com.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerTypeService")
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    @Qualifier(value = "iCustomerTypeRepository")
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getAll() {
        return customerTypeRepository.findAll();
    }
}
