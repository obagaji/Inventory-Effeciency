package com.jtc.Inventory.Effeciency.orderServices;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;

import java.util.List;

public class OnlineOrder implements PlacingOrder{

    @Override
    public boolean processOrder(double prices, int quantity) {
        return false;
    }

    @Override
    public boolean addOrder(List<Item> item) {
        return false;
    }
}
