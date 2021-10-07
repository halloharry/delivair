package com.delivair.service;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Product;

public interface ProductService {

    BaseResponse getAllProduct();

    BaseResponse addProduct(Product product);


}
