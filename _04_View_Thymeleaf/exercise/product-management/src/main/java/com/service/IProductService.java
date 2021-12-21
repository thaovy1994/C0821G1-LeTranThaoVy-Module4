package com.service;

import com.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> show();

    Product showDetail(String id);

    void create(Product product);

    void update(Product product);

    void delete(String id);

    List<Product> findByName(String name);
}
