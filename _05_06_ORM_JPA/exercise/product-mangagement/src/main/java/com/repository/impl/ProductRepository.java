package com.repository.impl;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> show() {
        List<Product> myList = BaseRepository.entityManager
                .createQuery("select s from product as s" , Product.class)
                .getResultList();
        return myList;
    }

    @Override
    public Product showDetail(String id) {
        return null;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}
