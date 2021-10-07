package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@Setter
@Getter
public class Product extends ModelBase {
    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private int amount;

    @Column
    private String code;

    @Column
    private int size;

    @Column
    private int price;

    @Column
    private String image;

    @Column
    private boolean is_ready;
}
