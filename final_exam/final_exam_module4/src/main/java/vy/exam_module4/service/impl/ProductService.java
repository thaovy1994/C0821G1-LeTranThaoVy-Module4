package vy.exam_module4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vy.exam_module4.dto.ProductDto;
import vy.exam_module4.model.Product;
import vy.exam_module4.repository.IProductRepository;
import vy.exam_module4.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findByName(Pageable pageable, String name) {
        Page<Product> productPage = productRepository.getByName(pageable, "%" + name + "%");
//        return questionPage;
        return productPage;
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = new Product(productDto.getId(), productDto.getName(), productDto.getPrice(), productDto.getStatus(),
                productDto.getProductType(), productDto.getOrderProduct());
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable of) {
        return productRepository.findAll(of);
    }
}
