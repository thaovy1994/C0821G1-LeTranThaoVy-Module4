package com.case_study.repository.employee;

import com.case_study.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iDivisionRepository")
public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
