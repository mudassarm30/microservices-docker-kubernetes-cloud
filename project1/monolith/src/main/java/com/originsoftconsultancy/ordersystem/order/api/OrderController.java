package com.originsoftconsultancy.ordersystem.order.api;

import com.originsoftconsultancy.ordersystem.order.application.OrderService;
import com.originsoftconsultancy.ordersystem.order.domain.Order;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestParam UUID customerId) {
        return orderService.createOrder(customerId);
    }
}
