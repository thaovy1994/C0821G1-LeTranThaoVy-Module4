package com.case_study.repository;

import com.case_study.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iDivisionRepository")
public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
