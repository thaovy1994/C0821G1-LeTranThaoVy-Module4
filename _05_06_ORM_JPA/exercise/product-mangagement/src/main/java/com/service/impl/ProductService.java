package com.service.impl;

import com.model.Product;
import com.repository.IProductRepository;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "productService")
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> show() {
        return repository.show();
    }

    @Override
    public Product showDetail(String id) {
        return repository.showDetail(id);
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }
}
