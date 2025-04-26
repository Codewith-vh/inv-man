package com.inventory.management.service.serviceimpl;

import com.inventory.management.dto.outbound.OutInventory;
import com.inventory.management.dto.outbound.ProductData;
import com.inventory.management.dto.outbound.Wastage;
import com.inventory.management.dto.outbound.WasteCollection;
import com.inventory.management.repository.InventoryProductDB;
import com.inventory.management.service.WasteCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WasteCollectionImpl implements WasteCollectionService {

    private final InventoryProductDB inventoryProductDB;
    public WasteCollectionImpl(InventoryProductDB inventoryProductDB){
        this.inventoryProductDB = inventoryProductDB;
    }

    @Override
    public WasteCollection remove() {
        List<OutInventory> inventoryList = inventoryProductDB.findAll();
        WasteCollection wastageColl= new WasteCollection();
        inventoryList.forEach(inventory -> {
            List<ProductData> pd= new ArrayList<>();
            inventory.getData().forEach(productData -> {
                if(productData.getExpiryDate().equalsIgnoreCase(String.valueOf(LocalDate.now().plusDays(1)))){
                    pd.add(productData);
                    wastageColl.getWastage().add(new Wastage(inventory));
                    inventory.setTotalQuantity(inventory.getTotalQuantity()- productData.getQuantity());
                    inventory.setLastUpdatedAt(String.valueOf(LocalDate.now()));

                }
            });
            pd.forEach(productData -> inventory.getData().remove(productData));
            inventoryProductDB.save(inventory);

        });
        return wastageColl;
    }
}
