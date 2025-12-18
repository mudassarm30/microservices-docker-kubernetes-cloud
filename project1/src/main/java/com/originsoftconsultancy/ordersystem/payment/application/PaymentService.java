package com.originsoftconsultancy.ordersystem.payment.application;

import com.originsoftconsultancy.ordersystem.order.application.PaymentPort;

import java.util.UUID;

public class PaymentService implements PaymentPort {

    @Override
    public void processPayment(UUID orderId) {
        // simulate payment
    }
}
