package com.case_study.repository.employee;

import com.case_study.model.employee.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iDegreeRepository")
public interface IDegreeRepository extends JpaRepository<Degree,Integer> {
}
