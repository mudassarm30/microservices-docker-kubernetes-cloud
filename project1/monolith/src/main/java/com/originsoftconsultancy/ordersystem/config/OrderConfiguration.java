package com.originsoftconsultancy.ordersystem.config;

import com.originsoftconsultancy.ordersystem.customer.application.CustomerService;
import com.originsoftconsultancy.ordersystem.inventory.application.InventoryService;
import com.originsoftconsultancy.ordersystem.order.application.OrderService;
import com.originsoftconsultancy.ordersystem.payment.application.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    OrderService orderService(
            CustomerService customerService,
            InventoryService inventoryService,
            PaymentService paymentService
    ) {
        return new OrderService(
                customerService,
                inventoryService,
                paymentService
        );
    }
}
