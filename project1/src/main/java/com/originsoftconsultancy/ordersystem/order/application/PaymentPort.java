package com.originsoftconsultancy.ordersystem.order.application;

import java.util.UUID;

public interface PaymentPort {
    void processPayment(UUID orderId);
}
