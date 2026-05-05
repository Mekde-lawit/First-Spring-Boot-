package com.api.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.demo.dtos.CheckoutRequest;
import com.api.demo.dtos.CheckoutResponse;
import com.api.demo.exceptions.CartEmptyException;
import com.api.demo.exceptions.CartNotFoundException;
import com.api.demo.exceptions.PaymentException;
import com.api.demo.models.Order;
import com.api.demo.repositories.CartRepository;
import com.api.demo.repositories.OrderRepository;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CheckoutService {
    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final CartRepository cartRepository;
    private final CartService cartService;
    private final PaymentGateway paymentGateway;

    @SuppressWarnings("null")
    @Transactional
    public CheckoutResponse checkout(CheckoutRequest request) throws StripeException {
        var cart = cartRepository.getCartWithItems(request.getCartId())
                .orElse(null);

        if (cart == null) {
            throw new CartNotFoundException();
        }

        if (cart.isEmpty()) {
            throw new CartEmptyException();
        }
        var order = Order.fromCart(cart, authService.getCurrentUser());
        orderRepository.save(order);
        try {
            // create a checkout session with stripe and get the url
            var session = paymentGateway.createCheckoutSession(order);

            cartService.clearCart(cart.getId());

            return new CheckoutResponse(order.getId(), session.getCheckoutUrl());
        } catch (PaymentException e) {
            orderRepository.delete(order);
            throw e;
        }
    }

    public void handleWebhookEvent(WebhookRequest request) {
        paymentGateway
                .parseWebhookRequest(request)
                .ifPresent(paymentResult -> {
                    @SuppressWarnings("null")
                    var order = orderRepository.findById(paymentResult.getOrderId()).orElseThrow();
                    order.setStatus(paymentResult.getPaymentStatus());
                    orderRepository.save(order);

                });
    }

}
