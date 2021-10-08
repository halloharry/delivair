package com.delivair.module.product.payload.request;

import lombok.Data;

@Data
public class ProductRequest {

    private String name;
    private String amount;
    private String brand;
    private String code;
    private String size;
    private String price;
    private String image;
    private String isReady;
    private String isDeleted;
    private String productCategory;
    private String productType;
}
