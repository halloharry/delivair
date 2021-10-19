package com.delivair.module.productCategory.payload.response;

import lombok.Data;
import java.util.LinkedList;
import java.util.List;

@Data
public class ProductCategoryListResponse {
    private List<ProductCategoryResponse> productCategoryResponses = new LinkedList<>();
}
