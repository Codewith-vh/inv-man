package com.inventory.management.dto.outbound;

import com.inventory.management.dto.inbound.Inventory;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
public class OutInventory {

    @Id
    private String productId;
    private String productName;
    private int totalQuantity;
    private int minimumCount;
    private String supplierName;
    private String location;
    private List<ProductData> data;
    private String lastUpdatedAt;
    private String createdAt;

    public OutInventory(Inventory inventory) {
        this.productId = inventory.getProductId();
        this.productName = inventory.getProductName();
        this.totalQuantity = inventory.getQuantity();
        this.minimumCount = inventory.getMinimumCount();
        this.supplierName = inventory.getSupplierName();
        this.location = inventory.getLocation();
        this.lastUpdatedAt = inventory.getUpdatedAt();
        this.createdAt = inventory.getCreatedAt();

        ProductData pd = new ProductData();
        pd.setQuantity(inventory.getQuantity());
        pd.setExpiryDate(inventory.getExpiredDate());

        this.data = List.of(pd);
    }
}
