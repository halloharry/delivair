package com.delivair.module.user.controller;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Product;
import com.delivair.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public BaseResponse addProduct(@RequestBody Product product){
        System.out.println(product);
        return productService.addProduct(product);
    }

}
