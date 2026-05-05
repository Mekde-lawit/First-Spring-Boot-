package com.api.demo.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.demo.repositories.CartRepository;
import com.api.demo.exceptions.CartNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;

    public void clearCart(UUID cartId) {
        var cart = cartRepository.getCartWithItems(cartId).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }

}
