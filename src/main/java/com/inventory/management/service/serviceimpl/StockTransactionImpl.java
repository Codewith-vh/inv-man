package com.inventory.management.service.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.management.dto.inventorycollectiondto.Inventory;
import com.inventory.management.dto.inventorycollectiondto.StockTransactionCollectionSet;
import com.inventory.management.repository.InventoryProductDB;
import com.inventory.management.service.StockTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StockTransactionImpl implements StockTransaction {


    @Autowired
    InventoryProductDB inventoryProductDB;


    @Override
    public String save(String stocktransaction) throws Exception {
        try {
            log.info(stocktransaction);
            ObjectMapper objectMapper = new ObjectMapper();
            StockTransactionCollectionSet data = objectMapper.readValue(stocktransaction, StockTransactionCollectionSet.class);
                data.getStockTransactionCollection().getStockTransaction().stream()
                        .filter(stockTransaction -> stockTransaction.getType().equalsIgnoreCase("Arrival"))
                        .forEach(stockTransaction -> {

                            Optional<Inventory> inventory = inventoryProductDB.findByProductId(stockTransaction.getInventoryId());
                            log.info(String.valueOf(inventory));
                            if (inventory.isPresent()) {
                                inventory.get().setQuantity(inventory.get().getQuantity() + stockTransaction.getQuantity());
                                inventory.get().setUpdatedAt(stockTransaction.getTimestamp());
                                inventoryProductDB.save(inventory.get());
                            } else {
                                log.info("Please configure the product: "+stockTransaction.getInventoryId());
                            }
                        });

            return "Saved Successfully";
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
