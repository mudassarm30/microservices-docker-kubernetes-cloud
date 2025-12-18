package com.originsoftconsultancy.ordersystem.inventory.application;

import com.originsoftconsultancy.ordersystem.order.application.InventoryPort;

public class InventoryService implements InventoryPort {

    @Override
    public boolean reserveStock(int quantity) {
        return quantity <= 10;
    }
}
