package com.delivair.module.productType.controller;

import com.delivair.common.payload.response.BaseResponse;
import com.delivair.module.productType.payload.request.EditProductTypeRequest;
import com.delivair.module.productType.payload.request.ProductTypeRequest;
import com.delivair.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @PostMapping("/add-type")
    public BaseResponse addType(@RequestBody ProductTypeRequest productTypeRequest){
        System.out.println(productTypeRequest);
        return productTypeService.addType(productTypeRequest);
    }

    @GetMapping("/all-type")
    public BaseResponse getAllType(){
        return productTypeService.getAllType();
    }

    @PostMapping("delete/{id}")
    public BaseResponse deleteType(@PathVariable ("id") Long id){
        System.out.println(id);
        return productTypeService.deleteType(id);
    }

    @PostMapping("/update/{id}")
    public BaseResponse updateType(@PathVariable("id") Long id, @RequestBody EditProductTypeRequest editProductTypeRequest) throws Exception {
        System.out.println(editProductTypeRequest);
        return productTypeService.updateType(editProductTypeRequest, id);
    }
}
