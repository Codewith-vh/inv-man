package com.inventory.management.controller;


import com.inventory.management.dto.inbound.InventoryCollectionSet;
import com.inventory.management.dto.inbound.StockTransactionCollectionSet;
import com.inventory.management.service.serviceimpl.InventoryCollectionServiceImpl;
import com.inventory.management.service.serviceimpl.StockTransactionImpl;
import com.inventory.management.service.serviceimpl.WasteCollectionImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class InventoryManagementController {

    private final InventoryCollectionServiceImpl inventoryCollectionImpl;
    private final StockTransactionImpl stockTransactionImpl;
    private final WasteCollectionImpl wasteCollectionImpl;

    @Autowired
    public InventoryManagementController(
            InventoryCollectionServiceImpl inventoryCollectionImpl,
            StockTransactionImpl stockTransactionImpl,
            WasteCollectionImpl wasteCollectionImpl
    ) {
        this.inventoryCollectionImpl = inventoryCollectionImpl;
        this.stockTransactionImpl = stockTransactionImpl;
        this.wasteCollectionImpl = wasteCollectionImpl;
    }

    @PostMapping(value= "/inventoryCollection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String inventoryCollection(@RequestBody InventoryCollectionSet inventoryCollection) throws Exception {
        log.info(String.valueOf(inventoryCollection));
        return inventoryCollectionImpl.save(inventoryCollection);

    }


    @PostMapping(value= "/stockTransactionCollection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String stockTransactionCollection(@RequestBody StockTransactionCollectionSet stockTransactionCollection) throws Exception {
        return stockTransactionImpl.save(stockTransactionCollection);
    }

//    @GetMapping(value= "/wastageCollection")
//    public WasteCollectionSet wastageCollection() throws Exception {
//
//    }
}
