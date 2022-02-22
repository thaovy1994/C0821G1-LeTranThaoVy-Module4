package com.case_study.repository.customer;

import com.case_study.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iCustomerTypeRepository")
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
