package com.originsoftconsultancy.ordersystem.order.application;


import java.time.Instant;
import java.util.UUID;

import com.originsoftconsultancy.ordersystem.order.domain.Order;
import com.originsoftconsultancy.ordersystem.order.domain.OrderStatus;

public class OrderService {

    public Order createOrder(UUID customerId) {
        return new Order(
                UUID.randomUUID(),
                customerId,
                OrderStatus.CREATED,
                Instant.now()
        );
    }
}
