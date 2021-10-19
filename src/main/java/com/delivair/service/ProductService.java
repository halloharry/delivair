package com.delivair.service;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.module.product.payload.request.EditProductRequest;
import com.delivair.module.product.payload.request.ProductRequest;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public interface ProductService {

    BaseResponse addProduct(ProductRequest productRequest);

    BaseResponse getAllProduct();

    BaseResponse deleteProduct (Long id);

    BaseResponse updateProduct (EditProductRequest editProductRequest, Long id) throws ParseException, InvocationTargetException, IllegalAccessException;


}
