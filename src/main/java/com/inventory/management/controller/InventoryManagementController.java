package com.inventory.management.controller;


import com.inventory.management.dto.inventorycollectiondto.Inventory;
import com.inventory.management.service.serviceimpl.InventoryCollectionServiceImpl;
import com.inventory.management.service.serviceimpl.StockTransactionImpl;
import com.inventory.management.service.serviceimpl.WasteCollectionImpl;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class InventoryManagementController {

    @Autowired
    InventoryCollectionServiceImpl inventoryCollectionImpl;
    @Autowired
    StockTransactionImpl stockTransactionImpl;
    @Autowired
    WasteCollectionImpl wasteCollectionImpl;

    @PostMapping(value= "/inventoryCollection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String inventoryCollection(@RequestBody String inventoryCollection) throws Exception {
        log.info(inventoryCollection);
        return inventoryCollectionImpl.save(inventoryCollection);

    }


    @PostMapping(value= "/stockTransactionCollection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String stockTransactionCollection(@RequestBody String stockTransactionCollection) throws Exception {
        log.info(stockTransactionCollection);
        return stockTransactionImpl.save(stockTransactionCollection);
    }

    @PostMapping(value= "/wastageCollection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String wastageCollection(@RequestBody String wastageCollection) throws Exception {
        log.info(wastageCollection);
        return wasteCollectionImpl.remove(wastageCollection);

    }
}
