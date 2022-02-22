package vy.exam_module4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vy.exam_module4.model.ProductType;
import vy.exam_module4.repository.IProductTypeRepository;
import vy.exam_module4.service.IProductService;
import vy.exam_module4.service.IProductTypeService;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAll() {
        return productTypeRepository.findAll();
    }
}
