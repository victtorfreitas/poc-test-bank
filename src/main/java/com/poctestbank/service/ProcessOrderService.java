package com.poctestbank.service;

import com.poctestbank.controller.dto.request.OrderRequest;

public interface ProcessOrderService {

    void insert(OrderRequest orderRequest);
}
