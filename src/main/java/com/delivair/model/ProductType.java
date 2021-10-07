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
public class ProductType extends ModelBase {

    @Column
    private String name;
}
