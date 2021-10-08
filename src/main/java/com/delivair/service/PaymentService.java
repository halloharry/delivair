package com.delivair.service;

import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Payment;

public interface PaymentService {

    BaseResponse getAllPayment();

    BaseResponse addPayment(Payment payment);
}
