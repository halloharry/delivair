package com.delivair.service.impl;

import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.common.util.MapperUtil;
import com.delivair.model.Product;
import com.delivair.model.ProductCategory;
import com.delivair.module.product.payload.response.ProductResponse;
import com.delivair.module.productCategory.payload.request.EditProductCategoryRequest;
import com.delivair.module.productCategory.payload.request.ProductCategoryRequest;
import com.delivair.module.productCategory.payload.response.ProductCategoryListResponse;
import com.delivair.module.productCategory.payload.response.ProductCategoryResponse;
import com.delivair.repository.ProductCategoryRepository;
import com.delivair.service.ProductCategoryService;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    public BaseResponse addCategory(ProductCategoryRequest productCategoryRequest) {
        try {
            ProductCategory productCategory = MapperUtil.parse(productCategoryRequest, ProductCategory.class, MatchingStrategies.STRICT);
            productCategory.setIsDeleted(0);

            productCategoryRepository.save(productCategory);
            return new BaseResponse(CommonMessage.SAVED, null);
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_SAVED);
        }
    }

    @Override
    public BaseResponse getAllCategory() {
        try {
            List<ProductCategory> productCategories = productCategoryRepository.findByIsDeleted(0);
            ProductCategoryListResponse productCategoryListResponse = new ProductCategoryListResponse();

            productCategories.forEach(temp -> {
                ProductCategoryResponse productCategoryResponse = MapperUtil.parse(temp, ProductCategoryResponse.class, MatchingStrategies.STRICT);
                productCategoryListResponse.getProductCategoryResponses().add(productCategoryResponse);
            });
            System.out.println();
            return new BaseResponse(CommonMessage.FOUND, productCategoryListResponse);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_FOUND);
        }
    }

    @Override
    public BaseResponse deleteCategory(Long id) {

        try {
            ProductCategory productCategory = productCategoryRepository.findById(id).get();
            productCategory.setIsDeleted(1);

            productCategoryRepository.save(productCategory);
            return new BaseResponse(CommonMessage.DELETED, null);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_DELETED);
        }
    }

    @Override
    public BaseResponse updateCategory(EditProductCategoryRequest editProductCategoryRequest, Long id) throws Exception {
        try {
            ProductCategory productCategory = productCategoryRepository.findById(id).get();
            productCategory.setName(editProductCategoryRequest.getName());

            productCategoryRepository.save(productCategory);
            return new BaseResponse(CommonMessage.UPDATED, productCategory);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_UPDATED);

        }
    }


}
