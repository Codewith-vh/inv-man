package com.inventory.management.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inventory.management.repository.InventoryProductDB;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Document(collection = "wastageCollection")
public class WasteCollection {



    @JsonProperty("WastageCollection")
    private List<Wastage> wastage;

    public WasteCollection() {
        this.wastage = new ArrayList<>();

    }
}
