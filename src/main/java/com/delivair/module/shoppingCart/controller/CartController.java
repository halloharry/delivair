package com.delivair.module.shoppingCart.controller;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Cart;
import com.delivair.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    CartService cartService;


    @PostMapping("/addToCart")
    public BaseResponse addProduct(@RequestBody Cart cart){
        System.out.println(cart);
        return cartService.addProductToCart(cart);
    }

    //Remove Product from Cart
    @DeleteMapping("/removeFromCart/{productId}")
    public BaseResponse deleteProduct(@PathVariable("productId") long productId)
    {
        System.out.println(productId);
       return cartService.delete(productId);
    }


    //CheckOut




}
