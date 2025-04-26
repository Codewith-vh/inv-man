package com.inventory.management.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class InventoryCollectionSet {
    @JsonProperty("InventoryCollection")
    private InventoryCollection inventoryCollection;
}
