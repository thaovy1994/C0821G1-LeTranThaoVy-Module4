package com.practice_lesson_11.repository;

import com.practice_lesson_11.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
