package com.delivair.module.product.controller;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.module.product.payload.request.EditProductRequest;
import com.delivair.module.product.payload.request.ProductRequest;
import com.delivair.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/all-product")
    public BaseResponse getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping("/add-product")
    public BaseResponse addProduct(@RequestBody ProductRequest productRequest){
        System.out.println(productRequest);
        return productService.addProduct(productRequest);
    }
    
    @PostMapping("/delete/{id}")
    public BaseResponse deleteProduct(@PathVariable("id") Long id) {
        System.out.println(id);
        return productService.deleteProduct(id);
    }
    
    @PostMapping("/update/{id}")
    public BaseResponse updateProduct(@PathVariable("id") Long id, @RequestBody EditProductRequest editProductRequest) throws ParseException, InvocationTargetException, IllegalAccessException {
        System.out.println(editProductRequest);
        return productService.updateProduct(editProductRequest, id);
    }




}
