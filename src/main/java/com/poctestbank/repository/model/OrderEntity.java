package com.poctestbank.repository.model;

import com.poctestbank.controller.dto.request.OrderRequest;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Document("ORDER")
public record OrderEntity(
        @MongoId
        String id,
        String destination,
        String origin,
        BigDecimal amount
) {
    public Boolean amountIsInvalid(){
        return amount.compareTo(BigDecimal.ZERO) <= 0;
    }
    public OrderEntity(OrderRequest orderRequest) {
        this(null, orderRequest.destination(), orderRequest.origin(), orderRequest.amount());
    }
}
