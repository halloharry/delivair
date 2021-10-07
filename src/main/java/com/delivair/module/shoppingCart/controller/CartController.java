package com.delivair.module.shoppingCart.controller;


import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Cart;
import com.delivair.service.CartService;
import com.delivair.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    ProductService productService;
    CartService cartService;

    @GetMapping("/allDataCart")
    public BaseResponse getAllDataCart() {
        return cartService.getDataFromCart();
    }

    @GetMapping("/addToCart")
    public BaseResponse addToCart(@RequestBody Cart cart){
        System.out.println(cart);
        return cartService.addProductToCart(cart);
    }

    //Remove Product from Cart


    //CheckOut




}
