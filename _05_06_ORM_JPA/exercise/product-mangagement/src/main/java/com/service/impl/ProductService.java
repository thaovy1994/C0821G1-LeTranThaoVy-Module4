package com.service.impl;

import com.model.Product;
import com.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<String, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put("1",new Product("PT-01","Milk",12.000,"no sugar","vnmilk"));
    }

    @Override
    public List<Product> show() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product showDetail(String id) {
        return productList.get(id);
    }

    @Override
    public void create(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void delete(String id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> myList = new ArrayList<>();
        for(Map.Entry<String, Product> map : productList.entrySet()){
            if(map.getValue().getName().contains(name)){
                myList.add(map.getValue());
            }
        }
        return myList;
    }
}
