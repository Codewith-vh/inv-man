package com.inventory.management.service;

import jakarta.xml.bind.JAXBException;

public interface StockTransaction {
    String save(String stocktransaction) throws Exception;
}
