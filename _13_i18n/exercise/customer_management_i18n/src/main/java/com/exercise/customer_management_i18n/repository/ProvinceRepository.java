package com.exercise.customer_management_i18n.repository;

import com.exercise.customer_management_i18n.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
