package com.inventory.management.repository;

import com.inventory.management.dto.inbound.StockTransactionCollectionSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTransactionDB extends MongoRepository<StockTransactionCollectionSet, String> {
}
