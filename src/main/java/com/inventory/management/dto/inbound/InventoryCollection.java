package com.inventory.management.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data

public class InventoryCollection {
    @JsonProperty("Inventory")
    private List<Inventory> inventory;
}
