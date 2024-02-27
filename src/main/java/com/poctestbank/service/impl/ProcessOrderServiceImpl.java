package com.poctestbank.service.impl;

import com.poctestbank.controller.dto.request.OrderRequest;
import com.poctestbank.repository.OrderRepository;
import com.poctestbank.repository.model.OrderEntity;
import com.poctestbank.service.ProcessOrderService;
import com.poctestbank.service.PublisherOrderService;
import com.poctestbank.service.dto.OrderNotify;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessOrderServiceImpl implements ProcessOrderService {

    private final OrderRepository orderRepository;
    private final PublisherOrderService publisherOrderService;
    @Value("${message.order.create}")
    private String messageDefault;


    @Override
    public void insert(OrderRequest orderRequest) {
        final var orderEntity = new OrderEntity(orderRequest);
        //Business rule
        if (orderEntity.amountIsInvalid()) {
            throw new RuntimeException();
        }

        orderRepository.save(orderEntity);
        publisherOrderService.notifyOrigin(new OrderNotify(orderEntity, messageDefault));
    }
}
