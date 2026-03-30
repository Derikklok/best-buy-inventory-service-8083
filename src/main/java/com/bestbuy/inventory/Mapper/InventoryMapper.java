package com.bestbuy.inventory.Mapper;

import com.bestbuy.inventory.Dto.InventoryRequestDTO;
import com.bestbuy.inventory.Dto.InventoryResponseDTO;
import com.bestbuy.inventory.Model.Inventory;

public class InventoryMapper {

    // Request to entity
    public static Inventory toEntity(InventoryRequestDTO dto) {
        return Inventory.builder()
                .productId(dto.getProductId())
                .availableStock(dto.getAvailableStock())
                .reservedStock(dto.getReservedStock())
                .build();
    }

    // From entity to response
    public static InventoryResponseDTO toDTO(Inventory inventory) {
        return InventoryResponseDTO.builder()
                .id(inventory.getId())
                .productId(inventory.getProductId())
                .availableStock(inventory.getAvailableStock())
                .reservedStock(inventory.getReservedStock())
                .totalStock(inventory.getTotalStock())
                .createdAt(inventory.getCreatedAt())
                .updatedAt(inventory.getUpdatedAt())
                .build();
    }

    // Update
    public static void updateEntity(Inventory inventory, InventoryRequestDTO dto) {
        inventory.setAvailableStock(dto.getAvailableStock());
        if (dto.getReservedStock() != null) {
            inventory.setReservedStock(dto.getReservedStock());
        }
    }
}


/*
public static void updateEntity(Inventory inventory, InventoryRequestDTO dto) {
        inventory.setAvailableStock(dto.getAvailableStock());
        if (dto.getReservedStock() != null) {
            inventory.setReservedStock(dto.getReservedStock());
        }
    }
 */