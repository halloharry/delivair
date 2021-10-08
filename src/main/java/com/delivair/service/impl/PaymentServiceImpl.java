package com.delivair.service.impl;

import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Payment;
import com.delivair.repository.PaymentRepository;
import com.delivair.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public BaseResponse getAllPayment(Payment payment) {
        try {
//            paymentRepository.findAll();
            return new BaseResponse(CommonMessage.FOUND, paymentRepository.findAll());
        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_FOUND);
        }
    }

    @Override
    public BaseResponse addPayment(Payment payment){
        try {
            paymentRepository.save(payment);
            return new BaseResponse(CommonMessage.SAVED);
        } catch (Exception e){
            System.out.println(e);
            return new BaseResponse(CommonMessage.NOT_SAVED);
        }
    }
}
