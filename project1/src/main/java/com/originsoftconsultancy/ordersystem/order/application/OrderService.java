package com.originsoftconsultancy.ordersystem.order.application;

import com.originsoftconsultancy.ordersystem.order.domain.Order;
import com.originsoftconsultancy.ordersystem.order.domain.OrderStatus;

import java.time.Instant;
import java.util.UUID;

public class OrderService {

    private final CustomerPort customerPort;
    private final InventoryPort inventoryPort;
    private final PaymentPort paymentPort;

    public OrderService(
            CustomerPort customerPort,
            InventoryPort inventoryPort,
            PaymentPort paymentPort
    ) {
        this.customerPort = customerPort;
        this.inventoryPort = inventoryPort;
        this.paymentPort = paymentPort;
    }

    public Order createOrder(UUID customerId) {

        if (!customerPort.isCustomerActive(customerId)) {
            throw new IllegalStateException("Inactive customer");
        }

        if (!inventoryPort.reserveStock(1)) {
            throw new IllegalStateException("Out of stock");
        }

        paymentPort.processPayment(UUID.randomUUID());

        return new Order(
                UUID.randomUUID(),
                customerId,
                OrderStatus.CONFIRMED,
                Instant.now()
        );
    }
}
