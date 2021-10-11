package com.delivair.exception;


import com.delivair.model.Product;

public class NotEnoughProductInStockException extends Exception {

    private static final String DEFAULT_MESSAGE = "Not enough products in stock";

    public NotEnoughProductInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughProductInStockException(Product product) {
        super(String.format("Not enough %s products in stock. Only %d left", product.getName(), product.getAmount()));
    }

}
