package com.inventory.management.service;

import com.inventory.management.dto.inventorycollectiondto.Inventory;
import jakarta.xml.bind.JAXBException;

public interface InventoryCollectionService {

    String save(String invColl) throws Exception;
}
