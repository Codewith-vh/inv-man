package com.inventory.management.repository;

import com.inventory.management.dto.outbound.OutInventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryProductDB extends MongoRepository <OutInventory,OutInventory > {

    Optional<OutInventory> findByProductId(String inventoryId);
}
