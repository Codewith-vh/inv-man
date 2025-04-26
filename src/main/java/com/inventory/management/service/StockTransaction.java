package com.inventory.management.service;

import com.inventory.management.dto.inbound.StockTransactionCollectionSet;
import jakarta.xml.bind.JAXBException;

public interface StockTransaction {
    String save(StockTransactionCollectionSet stocktransaction) throws Exception;
}
