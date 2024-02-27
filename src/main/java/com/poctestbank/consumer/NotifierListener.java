package com.poctestbank.consumer;

import com.poctestbank.service.dto.OrderNotify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotifierListener {

    @JmsListener(destination = "order_processed_notify")
    public void receiveMessage(OrderNotify orderNotify) {
        log.info("Received message: {}", orderNotify);
    }
}
