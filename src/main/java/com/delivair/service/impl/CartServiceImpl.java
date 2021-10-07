package com.delivair.service.impl;


import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.exception.NotEnoughProductInStockException;
import com.delivair.model.Cart;
import com.delivair.repository.CartRepository;
import com.delivair.repository.ProductRepository;
import com.delivair.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepository productRepository;
    CartRepository cartRepository;

    @Override
    public BaseResponse getDataFromCart() {
        return null;
    }


    @Override
    public BaseResponse addProductToCart(Cart cart) {
        try { cartRepository.save(cart);
            return new BaseResponse(CommonMessage.SAVED);
        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_SAVED);
        }
    }

    @Override
    public BaseResponse removeProductFromCart(Cart cart) {
        return null;
    }


    @Override
    public void checkout() throws NotEnoughProductInStockException {
    }



}
