package com.jtc.Inventory.Effeciency.inventoryEntities;

import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import org.springframework.data.annotation.Id;

public record Customer(@Id String name, AddressTable address, String phone, String email,
                       double totalPurchase,double recentPurchase) {
}
