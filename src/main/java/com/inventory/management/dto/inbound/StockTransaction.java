package com.inventory.management.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StockTransaction {
    @JsonProperty("TransactionId")
    private String transactionId;
    @JsonProperty("InventoryId")
    private String inventoryId;
    @JsonProperty("Quantity")
    private int quantity;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("ExpiryDate")
    private String expiryDate;
    @JsonProperty("Timestamp")
    private String timestamp;
}
