package com.poctestbank.service;

import com.poctestbank.service.dto.OrderNotify;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherOrderServiceImpl implements PublisherOrderService {
    private final JmsTemplate jmsTemplate;

    @Override
    public void notifyOrigin(OrderNotify orderNotify) {
        jmsTemplate.convertAndSend("order_processed_notify", orderNotify);
    }
}
