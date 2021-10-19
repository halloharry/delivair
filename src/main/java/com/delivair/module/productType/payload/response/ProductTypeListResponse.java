package com.delivair.module.productType.payload.response;

import lombok.Data;
import java.util.LinkedList;
import java.util.List;

@Data
public class ProductTypeListResponse {
    private List<ProductTypeResponse> productTypeResponses = new LinkedList<>();

}
