package com.inventory.management.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inventory.management.service.WasteCollectionService;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "WasteCollection")
public class WasteCollectionSet {
    @Id
    private String id;
    @JsonProperty("WasteCollection")
    private WasteCollectionService wasteCollection;
}
