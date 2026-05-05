package com.api.demo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.demo.dtos.CartDto;
import com.api.demo.dtos.CartItemDto;
import com.api.demo.models.Cart;
import com.api.demo.models.CartItem;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "items", source = "cartItems")
    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);

    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);

}
