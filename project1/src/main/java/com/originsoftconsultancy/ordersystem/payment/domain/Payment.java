package com.originsoftconsultancy.ordersystem.payment.domain;

import java.util.UUID;

public record Payment(
        UUID orderId,
        PaymentStatus status
) {}
