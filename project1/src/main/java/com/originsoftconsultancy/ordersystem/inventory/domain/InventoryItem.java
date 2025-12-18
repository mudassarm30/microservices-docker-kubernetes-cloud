package com.originsoftconsultancy.ordersystem.inventory.domain;

import java.util.UUID;

public record InventoryItem(
        UUID productId,
        int availableQuantity
) {}