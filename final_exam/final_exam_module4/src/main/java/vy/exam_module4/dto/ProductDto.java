package vy.exam_module4.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vy.exam_module4.model.OrderProduct;
import vy.exam_module4.model.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto implements Validator {

    private Integer id;
    @NotBlank(message = "Name is not empty")
    private String name;
//    @NotNull
    private Double price;

    private String status;

    @ManyToOne(targetEntity = ProductType.class)
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
    private ProductType productType;

    @ManyToOne(targetEntity = OrderProduct.class)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private OrderProduct orderProduct;

    public ProductDto() {
    }

    public ProductDto(Integer id, @NotBlank(message = "Name is not empty") String name, @NotNull Double price, String status, ProductType productType, OrderProduct orderProduct) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
        this.orderProduct = orderProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
