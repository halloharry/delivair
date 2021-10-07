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
public class User extends ModelBase {

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "is_enable", length = 1)
    private Integer isEnable;


}
