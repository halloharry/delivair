package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment extends ModelBase {

    @ManyToOne
    @JoinColumn(name = "fk_payment_type_id")
    private PaymentType paymentType;

    @Column(name = "total_payment")
    private Long totalPayment;

    @Column(name = "no_resi")
    private String noResi;

    @Column(name = "status")
    private String status;

//    @Column(name = "fk_order")
//    private int fkOrder;
    public Payment(){

    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Long getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Long totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getNoResi() {
        return noResi;
    }

    public void setNoResi(String noResi) {
        this.noResi = noResi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
