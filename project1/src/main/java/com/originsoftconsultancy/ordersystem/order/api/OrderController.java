package com.originsoftconsultancy.ordersystem.order.api;

import org.springframework.web.bind.annotation.*;

import com.originsoftconsultancy.ordersystem.order.application.OrderService;
import com.originsoftconsultancy.ordersystem.order.domain.Order;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService = new OrderService();

    @PostMapping
    public Order create(@RequestParam UUID customerId) {
        return orderService.createOrder(customerId);
    }
}
