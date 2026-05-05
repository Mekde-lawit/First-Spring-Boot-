package com.api.demo.exceptions;

public class PaymentException extends RuntimeException {
    public PaymentException() {
        super();
    }

    public PaymentException(String message) {
        super(message);
    }
}
