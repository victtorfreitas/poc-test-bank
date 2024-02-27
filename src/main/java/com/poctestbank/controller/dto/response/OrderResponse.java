package com.poctestbank.controller.dto.response;

import com.poctestbank.repository.model.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(String destination,
                            String origin,
                            BigDecimal amount) {
    public OrderResponse(OrderEntity orderEntity) {
        this(orderEntity.destination(), orderEntity.origin(),
                orderEntity.amount());
    }
}
