package com.inventory.management.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDate;

@Data
public class Wastage {
    @JsonProperty("ProductId")
    private String productId;
    @JsonProperty("ExpiryDate")
    private String expiryDate;
    @JsonProperty("Quantity")
    private int quantity;
    @JsonProperty("Timestamp")
    private String timestamp;

    public Wastage(OutInventory inventory){
        this.productId= inventory.getProductId();
        this.quantity = inventory.getData().getFirst().getQuantity();
        this.timestamp= String.valueOf(LocalDate.now());
        this.expiryDate= String.valueOf(LocalDate.now().plusDays(1));
    }
}
