package com.inventory.management.service.serviceimpl;

import com.inventory.management.dto.inbound.InventoryCollectionSet;
import com.inventory.management.dto.outbound.OutInventory;
import com.inventory.management.repository.InventoryProductDB;
import com.inventory.management.service.InventoryCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryCollectionServiceImpl implements InventoryCollectionService {

    private final InventoryProductDB inventoryProductDB;

    public InventoryCollectionServiceImpl(InventoryProductDB inventoryProductDB){
        this.inventoryProductDB= inventoryProductDB;
    }




    @Override
    public String save(InventoryCollectionSet invColl) throws Exception {
        try{
            invColl.getInventoryCollection().getInventory().forEach(inventory -> {
                OutInventory outInventory = new OutInventory(inventory);
                inventoryProductDB.save(outInventory);
            });
            return "Saved Successfully";

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
