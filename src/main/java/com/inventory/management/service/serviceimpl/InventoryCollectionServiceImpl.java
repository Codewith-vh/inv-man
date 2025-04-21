package com.inventory.management.service.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.management.dto.inventorycollectiondto.Inventory;
import com.inventory.management.dto.inventorycollectiondto.InventoryCollectionSet;
import com.inventory.management.repository.InventoryProductDB;
import com.inventory.management.service.InventoryCollectionService;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryCollectionServiceImpl implements InventoryCollectionService {

    @Autowired
    InventoryProductDB inventoryProductDB;




    @Override
    public String save(String invColl) throws Exception {
        try {
            log.info(invColl);
            ObjectMapper objectMapper = new ObjectMapper();
            InventoryCollectionSet inventoryCollection = objectMapper.readValue(invColl, InventoryCollectionSet.class);
            inventoryCollection.getInventoryCollection().getInventory().forEach(inventoryProductDB::save);
            return "Saved Successfully";
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
