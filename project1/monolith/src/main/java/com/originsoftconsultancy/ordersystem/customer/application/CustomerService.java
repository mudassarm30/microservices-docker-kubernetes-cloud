package com.originsoftconsultancy.ordersystem.customer.application;

import com.originsoftconsultancy.ordersystem.order.application.CustomerPort;

import java.util.UUID;

public class CustomerService implements CustomerPort {

    @Override
    public boolean isCustomerActive(UUID customerId) {
        return true; // stub
    }
}
