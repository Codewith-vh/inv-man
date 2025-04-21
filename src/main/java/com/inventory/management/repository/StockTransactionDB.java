package com.inventory.management.repository;

import com.inventory.management.dto.inventorycollectiondto.StockTransaction;
import com.inventory.management.dto.inventorycollectiondto.StockTransactionCollectionSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTransactionDB extends MongoRepository<StockTransactionCollectionSet, String> {
}
