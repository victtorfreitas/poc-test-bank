package com.poctestbank.service.dto;

import com.poctestbank.repository.model.OrderEntity;

import java.io.Serializable;
import java.math.BigDecimal;

public record OrderNotify(
        String origin,
        String message
) implements Serializable {
    public OrderNotify(OrderEntity orderEntity, String message) {
        this(orderEntity.origin(), message.replaceAll(":AMOUNT", orderEntity.amount().toEngineeringString()));
    }
}
