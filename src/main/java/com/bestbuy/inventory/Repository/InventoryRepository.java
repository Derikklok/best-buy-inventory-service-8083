package com.bestbuy.inventory.Repository;

import com.bestbuy.inventory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    // Find by product ID (most used query)
    Optional<Inventory> findByProductId(String productId);

    // Check if inventory exists for product
    boolean existsByProductId(String productId);

    // Find all low stock items (for alerts)
    List<Inventory> findByAvailableStockLessThan(Integer threshold);

    // Find all products out of stock
    List<Inventory> findByAvailableStock(Integer stock);
}
