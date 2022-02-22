package vy.exam_module4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vy.exam_module4.model.ProductType;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType,Integer> {
}
