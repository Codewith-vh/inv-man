package com.inventory.management.service.serviceimpl;

import com.inventory.management.dto.inbound.StockTransactionCollectionSet;
import com.inventory.management.dto.outbound.OutInventory;
import com.inventory.management.repository.InventoryProductDB;
import com.inventory.management.service.StockTransaction;
import com.inventory.management.uitilities.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.inventory.management.uitilities.ApplicationConstants.ARRIVAL;

@Service
@Slf4j
public class StockTransactionImpl implements StockTransaction {

    private final InventoryProductDB inventoryProductDB;
    private final ApplicationUtils applicationUtils;
    public StockTransactionImpl(InventoryProductDB inventoryProductDB, ApplicationUtils applicationUtils){
        this.inventoryProductDB = inventoryProductDB;
        this.applicationUtils =  applicationUtils;
    }


    public String save(StockTransactionCollectionSet stocktransaction) throws Exception {
        try {
            stocktransaction.getStockTransactionCollection().getStockTransaction().forEach(stockTransaction -> {
                Optional<OutInventory> optInv = inventoryProductDB.findByProductId(stockTransaction.getInventoryId());
                if(optInv.isPresent()) {
                    OutInventory inventory= optInv.get();
                    if (stockTransaction.getType().equalsIgnoreCase(ARRIVAL)) {
                        applicationUtils.handleArrivalTransaction(stockTransaction, inventory);
                    } else {
                        applicationUtils.handleSoldTransaction(stockTransaction, inventory);
                    }
                    inventoryProductDB.save(inventory);

                }
            });
            return "Saved Successfully";
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


}
