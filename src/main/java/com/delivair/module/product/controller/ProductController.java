package com.delivair.module.product.controller;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.module.product.payload.request.ProductRequest;
import com.delivair.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
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




}
