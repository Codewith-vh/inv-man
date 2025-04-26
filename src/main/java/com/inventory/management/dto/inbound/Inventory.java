package com.inventory.management.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Inventory {
    @Id
    @JsonProperty("ProductId")
    private String productId;

    @JsonProperty("ProductName")
    private String productName;

    @JsonProperty("Quantity")
    private int quantity;

    @JsonProperty("MinimumCount")
    private int minimumCount;

    @JsonProperty("UpdatedAt")
    private String updatedAt;

    @JsonProperty("CreatedAt")
    private String createdAt;

    @JsonProperty("ExpiredDate")
    private String expiredDate;

    @JsonProperty("SupplierName")
    private String supplierName;

    @JsonProperty("Location")
    private String location;
}