package com.inventory.management.uitilities;

import com.inventory.management.dto.outbound.OutInventory;
import com.inventory.management.dto.outbound.ProductData;

import java.util.ArrayList;

public class ApplicationUtils {
    public void handleSoldTransaction(com.inventory.management.dto.inbound.StockTransaction stockTransaction, OutInventory inventory) {
        ArrayList<ProductData> removal = new ArrayList<>();
        inventory.setTotalQuantity(inventory.getTotalQuantity()- stockTransaction.getQuantity());
        inventory.getData().forEach(productData -> {
            if(stockTransaction.getQuantity()>0){
                if(productData.getQuantity()>stockTransaction.getQuantity()){
                    productData.setQuantity(productData.getQuantity()- stockTransaction.getQuantity());
                    stockTransaction.setQuantity(0);
                }
                else{
                    stockTransaction.setQuantity(stockTransaction.getQuantity()-productData.getQuantity());
                    removal.add(productData);
                }
            }
        });

        removal.forEach(productData -> inventory.getData().remove(productData));

    }

    public void handleArrivalTransaction(com.inventory.management.dto.inbound.StockTransaction stockTransaction, OutInventory inventory) {
        ProductData pd = new ProductData();
        pd.setQuantity(stockTransaction.getQuantity());
        pd.setExpiryDate(stockTransaction.getExpiryDate());
        inventory.getData().add(pd);
        inventory.setTotalQuantity(inventory.getTotalQuantity() + stockTransaction.getQuantity());
        inventory.setLastUpdatedAt(stockTransaction.getTimestamp());
    }
}
