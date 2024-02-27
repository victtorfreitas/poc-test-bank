package com.poctestbank.service.impl;

import com.poctestbank.controller.dto.response.OrderResponse;
import com.poctestbank.repository.OrderRepository;
import com.poctestbank.repository.model.OrderEntity;
import com.poctestbank.service.FindOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindOrderServiceImpl implements FindOrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderResponse> getAllByDestination(String destination) {
        return orderRepository.findAllByDestinationContaining(destination)
                .stream()
                .map(OrderResponse::new)
                .toList();
    }
}
