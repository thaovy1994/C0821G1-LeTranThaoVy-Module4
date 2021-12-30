package com.customer_management_springboot.repository;

import com.customer_management_springboot.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByNameContainsOrEmailContainsOrAddressContains(String name, String email, String address);

    Page<Customer> findAllByNameContainsOrEmailContainsOrAddressContains(String name, String email, String address, Pageable pageInfo);
}
