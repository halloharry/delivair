package com.delivair.service.impl;

import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.common.util.MapperUtil;
import com.delivair.model.Product;
import com.delivair.model.ProductCategory;
import com.delivair.model.ProductType;
import com.delivair.module.product.payload.request.EditProductRequest;
import com.delivair.module.product.payload.request.ProductRequest;
import com.delivair.module.product.payload.response.ProductListResponse;
import com.delivair.module.product.payload.response.ProductResponse;
import com.delivair.repository.ProductCategoryRepository;
import com.delivair.repository.ProductRepository;
import com.delivair.repository.ProductTypeRepository;
import com.delivair.service.ProductService;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public BaseResponse addProduct(ProductRequest productRequest) {
        try {
            Product product = MapperUtil.parse(productRequest, Product.class, MatchingStrategies.STRICT);
            product.setIsDeleted(0);
            product.setIsReady(0);
            ProductCategory productCategory = productCategoryRepository.findByIdAndIsDeleted(productRequest.getProductCategoryId(), 0);
            product.setProductCategory(productCategory);
            productRepository.save(product);
            return new BaseResponse(CommonMessage.SAVED, null);
        } catch (Exception e) {
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
                productResponse.setProductCategory(temp.getProductCategory().getName());
                productResponse.setProductType(temp.getProductType().getName());
            });
            System.out.println();
            return new BaseResponse(CommonMessage.FOUND, productListResponse);
        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_FOUND);
        }

    }

    @Override
    public BaseResponse deleteProduct(Long id) {
        try {
            Product product = productRepository.findById(id).get();
            product.setIsDeleted(1);

            productRepository.save(product);
            return new BaseResponse(CommonMessage.DELETED, null);

        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_DELETED);
        }
    }

    @Override
    public BaseResponse updateProduct(EditProductRequest editProductRequest, Long id) throws ParseException, InvocationTargetException, IllegalAccessException {
        try {
            Product product = productRepository.findById(id).get();
            ProductCategory productCategory = productCategoryRepository.findByIdAndIsDeleted(editProductRequest.getProductCategoryId(), 0);
            ProductType productType = productTypeRepository.findByIdAndIsDeleted(editProductRequest.getProductTypeId(), 0);

            product.setName(editProductRequest.getName());
            product.setBrand(editProductRequest.getBrand());
            product.setAmount(Integer.parseInt(editProductRequest.getAmount()));
            product.setCode(editProductRequest.getCode());
            product.setSize(Integer.parseInt(editProductRequest.getSize()));
            product.setPrice(Integer.parseInt(editProductRequest.getPrice()));
            product.setImage(editProductRequest.getImage());
            product.setIsReady(Integer.parseInt(editProductRequest.getIsReady()));
            product.setProductCategory(productCategory);
            product.setProductType(productType);

            productRepository.save(product);

            return new BaseResponse(CommonMessage.UPDATED, product);

        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_UPDATED);
        }
    }

}
