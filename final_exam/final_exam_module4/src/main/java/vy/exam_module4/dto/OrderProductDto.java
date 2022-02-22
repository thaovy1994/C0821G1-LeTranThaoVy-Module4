package vy.exam_module4.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vy.exam_module4.model.Product;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

public class OrderProductDto implements Validator {

    private Integer orderId;

    private String date_buy;
//    @Min(value = 1, message = "salary must be positive number")
    private Integer quantity;

    @JsonBackReference
    @OneToMany(targetEntity = Product.class, mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> productList;

    public OrderProductDto() {
    }

    public OrderProductDto(Integer orderId, String date_buy, Integer quantity, List<Product> productList) {
        this.orderId = orderId;
        this.date_buy = date_buy;
        this.quantity = quantity;
        this.productList = productList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDate_buy() {
        return date_buy;
    }

    public void setDate_buy(String date_buy) {
        this.date_buy = date_buy;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
