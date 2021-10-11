package com.delivair.service.impl;

import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.common.util.MapperUtil;
import com.delivair.model.Product;
import com.delivair.module.product.payload.request.EditProductRequest;
import com.delivair.module.product.payload.request.ProductRequest;
import com.delivair.module.product.payload.response.ProductListResponse;
import com.delivair.module.product.payload.response.ProductResponse;
import com.delivair.repository.ProductRepository;
import com.delivair.service.ProductService;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public BaseResponse addProduct(ProductRequest productRequest) {
        try {
            Product product = MapperUtil.parse(productRequest, Product.class, MatchingStrategies.STRICT);
            product.setIsDeleted(0);

            productRepository.save(product);
            return new BaseResponse(CommonMessage.SAVED, product);
        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_SAVED);
        }
    }

    @Override
    public BaseResponse getAllProduct() {
        try {
            List<Product> products = productRepository.findByIsDeleted(0);
            ProductListResponse productListResponse = new ProductListResponse();

            products.forEach(temp -> {
                ProductResponse productResponse = MapperUtil.parse(temp, ProductResponse.class, MatchingStrategies.STRICT);
                productListResponse.getProductResponses().add(productResponse);
            });
            System.out.println();
            return new BaseResponse(CommonMessage.FOUND, productListResponse);
        } catch (Exception e){
            return new BaseResponse(CommonMessage.NOT_FOUND);
        }

    }

    @Override
    public BaseResponse deleteProduct(Long id){
        try {
            Product product = productRepository.findById(id).get();
            product.setIsDeleted(1);

            productRepository.save(product);
          return new BaseResponse(CommonMessage.DELETED, null);

        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_SAVED);
        }
    }

    @Override
    public BaseResponse updateProduct(EditProductRequest editProductRequest, Long id){
        try {
            Product product = productRepository.findById(id).get();
            product.setName(editProductRequest.getName());
            productRepository.save(product);
            return new BaseResponse(CommonMessage.UPDATED, product);

        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_UPDATED);
        }
    }

}
