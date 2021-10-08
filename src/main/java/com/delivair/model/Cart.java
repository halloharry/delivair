package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart extends ModelBase {

    @Column(name = "product_ID")
    private  int productId;

    @Column(name = "order_id")
    private int orderID;

    @Column(name = "list_product")
    private String listProduct;

    @Column(name = "total_price")
    private long totalPrice;

    @Column(name = "amount")
    private int amount;




}
