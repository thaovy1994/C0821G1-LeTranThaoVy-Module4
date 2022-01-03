package com.shopping_cart.repository;

import com.shopping_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
