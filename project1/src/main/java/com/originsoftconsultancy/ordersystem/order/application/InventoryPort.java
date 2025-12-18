package com.originsoftconsultancy.ordersystem.order.application;

public interface InventoryPort {
    boolean reserveStock(int quantity);
}
