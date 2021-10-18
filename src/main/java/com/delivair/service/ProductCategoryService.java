package com.delivair.service;

import com.delivair.common.payload.response.BaseResponse;
import com.delivair.module.productCategory.payload.request.EditProductCategoryRequest;
import com.delivair.module.productCategory.payload.request.ProductCategoryRequest;

public interface ProductCategoryService {

    BaseResponse addCategory(ProductCategoryRequest productCategoryRequest);

    BaseResponse getAllCategory();

    BaseResponse deleteCategory (Long id);

    BaseResponse updateCategory (EditProductCategoryRequest editProductCategoryRequest, Long id) throws Exception;
}
