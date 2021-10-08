package com.delivair.service.impl;

import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Product;
import com.delivair.repository.ProductRepository;
import com.delivair.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public BaseResponse getAllProduct() {
        return new BaseResponse(CommonMessage.FOUND); }

    @Override
    public BaseResponse addProduct(Product product) {
        try { productRepository.save(product);
            return new BaseResponse(CommonMessage.SAVED);
        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_SAVED);
        }
    }
}
