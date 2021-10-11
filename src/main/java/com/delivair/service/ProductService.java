package com.delivair.service;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.module.product.payload.request.ProductRequest;

public interface ProductService {

    BaseResponse addProduct(ProductRequest productRequest);

    BaseResponse getAllProduct();

    BaseResponse deleteProduct (Long id);


}
