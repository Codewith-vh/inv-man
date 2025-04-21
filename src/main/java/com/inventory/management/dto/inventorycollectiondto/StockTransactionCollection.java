package com.inventory.management.dto.inventorycollectiondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class StockTransactionCollection {
    @Id
    private String id;
    @JsonProperty("StockTransaction")
    private List<StockTransaction> stockTransaction;

}
