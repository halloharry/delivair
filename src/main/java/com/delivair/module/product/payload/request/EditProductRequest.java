package com.delivair.module.product.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EditProductRequest {

    private String name;
    private String amount;
    private String brand;
    private String code;
    private String size;
    private String price;
    private String image;
    private String isReady;
    private String isDeleted;

    @JsonProperty(value = "product_category_id")
    private Long productCategoryId;

    @JsonProperty(value = "product_type_id")
    private Long productTypeId;
}
