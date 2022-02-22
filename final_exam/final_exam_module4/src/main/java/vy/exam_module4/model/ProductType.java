package vy.exam_module4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer productTypeId;
    @Column
    private String name;

    @JsonBackReference
    @OneToMany(targetEntity = Product.class, mappedBy = "productType", cascade = CascadeType.ALL)
    private List< Product > productList;

    public ProductType() {
    }

    public ProductType(Integer productTypeId, String name, List<Product> productList) {
        this.productTypeId = productTypeId;
        this.name = name;
        this.productList = productList;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
