package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends ModelBase {

    @Column(name = "order_id")
    private int orderID;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "amount")
    private int amount;

    @Column(name = "code")
    private String code;

    @Column(name = "size")
    private int size;

    @Column(name = "price")
    private int price;

    @Column(name = "image")
    private String image;

    @Column(name = "is_ready")
    private boolean is_ready;

    @ManyToOne
    @JoinColumn(name = "fk_product_category_id")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "fk_product_type_id")
    private ProductType productType;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIs_ready() {
        return is_ready;
    }

    public void setIs_ready(boolean is_ready) {
        this.is_ready = is_ready;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
