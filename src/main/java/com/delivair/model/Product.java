package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
    private int isReady;

    @ManyToOne
    @JoinColumn(name = "fk_product_category_id")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "fk_product_type_id")
    private ProductType productType;
}
