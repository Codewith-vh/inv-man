package com.inventory.management.service;

import com.inventory.management.dto.inbound.InventoryCollectionSet;

public interface InventoryCollectionService {

    String save(InventoryCollectionSet invColl) throws Exception;
}
