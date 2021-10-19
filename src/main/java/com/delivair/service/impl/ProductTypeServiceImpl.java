package com.delivair.service.impl;

import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.common.util.MapperUtil;
import com.delivair.model.ProductType;
import com.delivair.module.productType.payload.request.EditProductTypeRequest;
import com.delivair.module.productType.payload.request.ProductTypeRequest;
import com.delivair.module.productType.payload.response.ProductTypeListResponse;
import com.delivair.module.productType.payload.response.ProductTypeResponse;
import com.delivair.repository.ProductTypeRepository;
import com.delivair.service.ProductTypeService;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public BaseResponse addType(ProductTypeRequest productTypeRequest) {
        try {
            ProductType productType = MapperUtil.parse(productTypeRequest, ProductType.class, MatchingStrategies.STRICT);
            productType.setIsDeleted(0);

            productTypeRepository.save(productType);
            return new BaseResponse(CommonMessage.SAVED, null);
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_SAVED);
        }
    }

    @Override
    public BaseResponse getAllType() {
        try {
            List<ProductType> productTypes = productTypeRepository.findByIsDeleted(0);
            ProductTypeListResponse productTypeListResponse = new ProductTypeListResponse();

            productTypes.forEach(temp -> {
                ProductTypeResponse productTypeResponse = MapperUtil.parse(temp, ProductTypeResponse.class, MatchingStrategies.STRICT);
                productTypeListResponse.getProductTypeResponses().add(productTypeResponse);
            });
            System.out.println();
            return new BaseResponse(CommonMessage.FOUND, productTypeListResponse);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_FOUND);
        }
    }

    @Override
    public BaseResponse deleteType(Long id) {

        try {
            ProductType productType = productTypeRepository.findById(id).get();
            productType.setIsDeleted(1);

            productTypeRepository.save(productType);
            return new BaseResponse(CommonMessage.DELETED, null);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_DELETED);
        }
    }

    @Override
    public BaseResponse updateType(EditProductTypeRequest editProductTypeRequest, Long id) throws Exception {
        try {
            ProductType productType = productTypeRepository.findById(id).get();
            productType.setName(editProductTypeRequest.getName());

            productTypeRepository.save(productType);
            return new BaseResponse(CommonMessage.UPDATED, productType);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_UPDATED);

        }
    }
}
