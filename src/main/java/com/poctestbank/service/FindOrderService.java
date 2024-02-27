package com.poctestbank.service;

import com.poctestbank.controller.dto.response.OrderResponse;

import java.util.List;

public interface FindOrderService {

    List<OrderResponse> getAllByDestination(String destination);
}
