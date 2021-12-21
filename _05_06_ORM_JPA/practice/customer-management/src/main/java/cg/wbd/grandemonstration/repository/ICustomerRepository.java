package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer save(Customer customer);
}
