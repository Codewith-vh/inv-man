package com.inventory.management.dto.inventorycollectiondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inventory.management.service.WasteCollection;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "WasteCollection")
public class WasteCollectionSet {
    @Id
    private String id;
    @JsonProperty("WasteCollection")
    private WasteCollection wasteCollection;
}
