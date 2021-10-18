package com.delivair.module.productCategory.controller;

import com.delivair.common.payload.response.BaseResponse;
import com.delivair.module.product.payload.request.EditProductRequest;
import com.delivair.module.productCategory.payload.request.EditProductCategoryRequest;
import com.delivair.module.productCategory.payload.request.ProductCategoryRequest;
import com.delivair.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

@RestController
@RequestMapping ("/category")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping("/add-category")
    public BaseResponse addCategory(@RequestBody ProductCategoryRequest productCategoryRequest){
        System.out.println(productCategoryRequest);
        return productCategoryService.addCategory(productCategoryRequest);
    }

    @GetMapping("/all-category")
    public BaseResponse getAllCategory(){
        return productCategoryService.getAllCategory();
    }

    @PostMapping("delete/{id}")
    public BaseResponse deleteCategory(@PathVariable ("id") Long id){
        System.out.println(id);
        return productCategoryService.deleteCategory(id);
    }

    @PostMapping("/update/{id}")
    public BaseResponse updateProduct(@PathVariable("id") Long id, @RequestBody EditProductCategoryRequest editProductCategoryRequest) throws Exception {
        System.out.println(editProductCategoryRequest);
        return productCategoryService.updateCategory(editProductCategoryRequest, id);
    }
}
