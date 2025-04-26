package com.inventory.management.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wastage {
    @JsonProperty("ProductId")
    private String productId;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonProperty("ExpiredDate")
    private String expiredDate;
    @JsonProperty("Reason")
    private String reason;
    @JsonProperty("Quantity")
    private String quantity;
}
