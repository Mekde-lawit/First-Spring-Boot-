package com.api.demo.exceptions;

public class CartEmptyException extends RuntimeException {
    public CartEmptyException() {
        super("Cart is empty.");
    }

    public CartEmptyException(String message) {
        super(message);
    }
}
