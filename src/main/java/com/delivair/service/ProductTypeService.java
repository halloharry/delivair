package com.delivair.service;

import com.delivair.common.payload.response.BaseResponse;
import com.delivair.module.productType.payload.request.EditProductTypeRequest;
import com.delivair.module.productType.payload.request.ProductTypeRequest;

public interface ProductTypeService {

    BaseResponse addType(ProductTypeRequest productTypeRequest);

    BaseResponse getAllType();

    BaseResponse deleteType (Long id);

    BaseResponse updateType (EditProductTypeRequest editProductTypeRequest, Long id) throws Exception;
}
