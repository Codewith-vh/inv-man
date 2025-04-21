package com.inventory.management.repository;

import com.inventory.management.dto.inventorycollectiondto.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryProductDB extends MongoRepository <Inventory,String > {

    Optional<Inventory> findByProductId(String inventoryId);
}
