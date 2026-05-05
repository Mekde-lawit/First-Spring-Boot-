package com.api.demo.dtos;

import lombok.Data;

@Data
public class CheckoutResponse {

    private Long orderId;
    private String url;

    public CheckoutResponse(Long orderId) {
        this.orderId = orderId;
    }

    public CheckoutResponse(Long id, String url) {
        this.orderId = id;
        this.url = url;
    }

}
