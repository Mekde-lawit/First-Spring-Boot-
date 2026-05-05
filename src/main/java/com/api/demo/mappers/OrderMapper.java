package com.api.demo.mappers;

import org.mapstruct.Mapper;

import com.api.demo.dtos.OrderDto;
import com.api.demo.models.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
}
