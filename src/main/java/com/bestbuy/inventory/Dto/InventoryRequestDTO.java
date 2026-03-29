package com.bestbuy.inventory.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryRequestDTO {

    @NotBlank(message = "Product ID is required")
    private String productId;

    @NotNull(message = "Available stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer availableStock;

    @Min(value = 0, message = "Reserved stock cannot be negative")
    private Integer reservedStock = 0;
}
