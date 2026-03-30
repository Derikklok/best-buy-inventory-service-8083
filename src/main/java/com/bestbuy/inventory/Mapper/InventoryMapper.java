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
Scenario: The "Ghost Cart" Glitch
Imagine a customer put 2 TVs in their digital shopping cart. The system correctly moved 2 TVs into reservedStock.
But then, the customer's laptop battery died, and their internet disconnected before they could pay or cancel.

To the database, those 2 TVs are permanently stuck in "reserved" limbo! Nobody else can buy them.

A Store Admin notices this. They open their Admin Dashboard screen (in Angular), watch at the TV inventory, and say: "Those 2 TVs have been reserved for 3 days. I am canceling that."

The Admin fills out the update form:

    Available Stock: 10

    Reserved Stock: 0 (They manually force it to zero)

When the form hits your Java backend, your code sees that the ReservedStock box has a 0 in it. It overwrites the database, clearing out the "Ghost Carts" and making those TVs available for real customers to buy again!
 */