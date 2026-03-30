package com.bestbuy.inventory.Exception;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(String productId) {
        super("Inventory not found for product: " + productId);
    }
}
