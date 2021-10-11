package com.delivair.module.payment.payload.response;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class PaymentListResponse {
    private List<PaymentResponse> paymentResponses = new LinkedList<>();
}
