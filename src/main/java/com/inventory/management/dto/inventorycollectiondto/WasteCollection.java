package com.inventory.management.dto.inventorycollectiondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "wastageCollection")
public class WasteCollection {
    @Id
    private String id;
    @JsonProperty("WastageCollection")
    private List<Wastage> wastage;

}
