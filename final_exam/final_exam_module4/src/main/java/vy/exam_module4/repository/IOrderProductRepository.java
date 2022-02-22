package vy.exam_module4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vy.exam_module4.model.OrderProduct;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProduct,Integer> {
}
