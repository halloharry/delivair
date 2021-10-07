package com.delivair.module.shoppingCart.controller;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Cart;
import com.delivair.model.Product;
import com.delivair.service.CartService;
import com.delivair.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/allDataCart")
    public BaseResponse getAllDataCart() {
        return cartService.getDataFromCart();
    }

    @PostMapping("/addToCart")
    public BaseResponse addProduct(@RequestBody Cart cart){
        System.out.println(cart);
        return cartService.addProductToCart(cart);
    }

    //Remove Product from Cart


    //CheckOut




}
