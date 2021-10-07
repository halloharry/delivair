package com.delivair.module.payment.controller;

import com.delivair.model.Payment;
import com.delivair.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    // get all payment
    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    //payment
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        return paymentRepository.save(payment);
    }

}
