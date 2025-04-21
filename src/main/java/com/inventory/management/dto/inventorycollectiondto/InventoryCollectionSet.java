package com.inventory.management.dto.inventorycollectiondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "InventoryCollection")
public class InventoryCollectionSet {
    @JsonProperty("InventoryCollection")
    private InventoryCollection inventoryCollection;
}
