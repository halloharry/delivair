package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User extends ModelBase {

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "is_enable", length = 1)
    private int isEnable;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password, int isEnable) {
        this.username = username;
        this.password = password;
        this.isEnable = isEnable;
    }
}
