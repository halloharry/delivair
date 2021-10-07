package com.delivair.model;

import com.delivair.common.auditable.ModelBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_order")
public class Order extends ModelBase {

//    @Column(name = "user_id")
//    private int userID;

    @Column(name = "total_price")
    private long totalPrice;

    @Column(name = "amount")
    private int amount;

    @Column(name = "status")
    private String status;

    @Column(name = "is_cancel")
    private boolean isCancel;


//    public int getUserID() {
//        return userID;
//    }
//
//    public void setUserID(int userID) {
//        this.userID = userID;
//    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }
}
