package com.api.demo.services;

import java.util.Optional;

import com.api.demo.models.Order;

public interface PaymentGateway {
    CheckoutSession createCheckoutSession(Order order);

    Optional<PaymentResult> parseWebhookRequest(WebhookRequest request);
}
