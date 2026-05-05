package com.api.demo.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddItemToCartRequest {

    @NonNull
    private Long productId;

}
