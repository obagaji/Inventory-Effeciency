package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierItem  implements Supplier<Item> {
    @Override
    public Item get()
    {
        Item item = new Item();
        item.setItemProductId(0);
        item.setItemDescription(" NO value");
        item.setItemName("No Value");
        item.setItemExpirationDate(new Date(System.currentTimeMillis()));
        item.setItemQuantityInStock(0);
        item.setDate_time_in(new Date(System.currentTimeMillis()));
        item.setCurrent_date_time(new Date(System.currentTimeMillis()));
        item.setItemSellingPrice(00);
        return item;
    }
}
