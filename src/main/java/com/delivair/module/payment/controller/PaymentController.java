package com.delivair.module.payment.controller;

import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Payment;
import com.delivair.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    // get all payment
    @GetMapping("/all-payment")
    public BaseResponse getAllPayment(Payment payment){
        return paymentService.getAllPayment(payment);
    }

    //payment
    @PostMapping("/add-payment")
    public BaseResponse addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

}
