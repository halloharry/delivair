package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment_type")
@Setter
@Getter
public class PaymentType extends ModelBase {

    @Column
    private String name;
}
