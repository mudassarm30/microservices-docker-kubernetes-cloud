package com.originsoftconsultancy.ordersystem.order.application;

import java.util.UUID;

public interface CustomerPort {
    boolean isCustomerActive(UUID customerId);
}
