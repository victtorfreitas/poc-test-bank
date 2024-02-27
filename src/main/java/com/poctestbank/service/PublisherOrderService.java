package com.poctestbank.service;

import com.poctestbank.service.dto.OrderNotify;

public interface PublisherOrderService {

    void notifyOrigin(OrderNotify orderNotify);
}
