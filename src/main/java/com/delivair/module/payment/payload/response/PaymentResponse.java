package com.delivair.module.payment.payload.response;

import lombok.Data;

@Data
public class PaymentResponse {
    private String id;
    private String name;
    private String totalPayment;
    private String noResi;
    private String status;
}
