package com.bestbuy.inventory.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class InventoryResponseDTO {
    private String id;
    private String productId;
    private Integer availableStock;
    private Integer reservedStock;
    private Integer totalStock;
    private Instant createdAt;
    private Instant updatedAt;
}
