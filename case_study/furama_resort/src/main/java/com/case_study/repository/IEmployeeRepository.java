package com.case_study.repository;

import com.case_study.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select  * from blog where name like :name", nativeQuery = true)
    List<Employee> getByName(@Param("name") String name);
}