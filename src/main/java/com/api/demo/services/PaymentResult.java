package com.api.demo.services;

import com.api.demo.models.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PaymentResult {
    private Long orderId;
    private PaymentStatus paymentStatus;
}
