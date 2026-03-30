package com.bestbuy.inventory.Exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String productId, Integer requested, Integer available) {
        super(String.format("Insufficient stock for product %s. Requested %d, currently available : %d",
                productId, requested, available)
        );
    }
}
