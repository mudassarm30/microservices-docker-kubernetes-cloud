package com.originsoftconsultancy.ordersystem.customer.domain;

import java.util.UUID;

public record Customer(
        UUID id,
        String name,
        boolean active
) {}
