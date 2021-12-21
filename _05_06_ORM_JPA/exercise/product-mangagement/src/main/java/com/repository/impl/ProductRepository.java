package com.repository.impl;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
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
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        System.out.println("err");
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Product> findByName(String name) {
        //search by primary key
//        return BaseRepository.entityManager.find(Product.class, id);

        List<Product> myList = BaseRepository.entityManager
                .createQuery("select s from product as s where s.name = ?1" , Product.class)

                .getResultList();
        return myList;
    }
}
