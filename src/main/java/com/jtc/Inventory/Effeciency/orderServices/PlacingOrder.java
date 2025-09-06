package com.jtc.Inventory.Effeciency.orderServices;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;

import java.util.List;

public interface PlacingOrder
{
    boolean processOrder(double prices, int quantity );
    boolean addOrder(List<Item> item);
}
