package vy.exam_module4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private Integer orderProductId;
    @Column
    private String date_buy;
    @Column
    private Integer quantity;

    @JsonBackReference
    @OneToMany(targetEntity = Product.class, mappedBy = "orderProduct", cascade = CascadeType.ALL)
    private List< Product > productList;

    public OrderProduct() {
    }

    public OrderProduct(Integer orderProductId, String date_buy, Integer quantity, List<Product> productList) {
        this.orderProductId = orderProductId;
        this.date_buy = date_buy;
        this.quantity = quantity;
        this.productList = productList;
    }

    public Integer getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
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
}


