package com.inventory.management.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class StockTransactionCollection {
    @Id
    private String id;
    @JsonProperty("StockTransaction")
    private List<StockTransaction> stockTransaction;

}
