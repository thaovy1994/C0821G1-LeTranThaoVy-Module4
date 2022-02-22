package vy.exam_module4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vy.exam_module4.dto.ProductDto;
import vy.exam_module4.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product findById(Integer id);

    Page<Product> findByName(Pageable pageable, String name);

//    Page<Product> findByTitleAndQuestionTypePage(String titleNew, String questionTypeNew, Pageable pageable);

    void save(ProductDto productDto);

//    void remove(Integer id);

    Page<Product> findAll(Pageable of);
}
