package com.delivair.service.impl;


import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.exception.NotEnoughProductInStockException;
import com.delivair.model.Cart;
import com.delivair.repository.CartRepository;
import com.delivair.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;


    @Override
    public BaseResponse addProductToCart(Cart cart) {
        try { cartRepository.save(cart);
            return new BaseResponse(CommonMessage.SAVED, cart);
        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_SAVED);
        }
    }

    @Override
    public BaseResponse delete(long productId) {
        try { cartRepository.deleteById(productId);
            return new BaseResponse(CommonMessage.DELETED);
        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_DELETED);
        }
    }


}
