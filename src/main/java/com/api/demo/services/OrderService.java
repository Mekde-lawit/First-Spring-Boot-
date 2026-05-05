package com.api.demo.services;

import com.api.demo.mappers.OrderMapper;
import com.api.demo.repositories.OrderRepository;
import com.api.demo.dtos.OrderDto;
import com.api.demo.exceptions.OrderNotFoundException;

import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final AuthService authService;

    public List<OrderDto> getAllOrders() {
        var user = authService.getCurrentUser();
        var orders = orderRepository.getOrdersByCustomer(user);
        return orders.stream().map(orderMapper::toDto).toList();
    }

    public OrderDto getOrder(Long orderId) {
        var order = orderRepository
                .getOrderWithItems(orderId)
                .orElseThrow(OrderNotFoundException::new);
        var user = authService.getCurrentUser();
        if (!order.isPlacedBy(user)) {
            throw new AccessDeniedException("Unauthorized : You don't have access to this order");
        }
        return orderMapper.toDto(order);
    }
}
