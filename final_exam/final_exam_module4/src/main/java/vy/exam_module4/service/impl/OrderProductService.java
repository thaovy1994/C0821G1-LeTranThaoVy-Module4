package vy.exam_module4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vy.exam_module4.model.OrderProduct;
import vy.exam_module4.repository.IOrderProductRepository;
import vy.exam_module4.service.IOrderProductService;

import java.util.List;

@Service
public class OrderProductService implements IOrderProductService {
    @Autowired
    private IOrderProductRepository orderProductRepository;

    @Override
    public List<OrderProduct> getAll() {
        return orderProductRepository.findAll();
    }
}
