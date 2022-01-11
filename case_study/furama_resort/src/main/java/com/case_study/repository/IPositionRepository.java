package com.case_study.repository;

import com.case_study.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iPositionRepository")
public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
