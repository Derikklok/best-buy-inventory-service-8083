package com.bestbuy.inventory.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false,unique = true)
    private String productId;              // Links to product service

    @Column(nullable = false)
    @Builder.Default
    private Integer availableStock = 0;    // stock ready to sell

    @Column(nullable = false)
    @Builder.Default
    private Integer reservedStock = 0;
}
