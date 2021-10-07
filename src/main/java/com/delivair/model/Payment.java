package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Setter
@Getter
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


}
