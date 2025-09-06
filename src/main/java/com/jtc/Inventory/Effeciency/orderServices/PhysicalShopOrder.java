package com.jtc.Inventory.Effeciency.orderServices;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import com.jtc.Inventory.Effeciency.inventoryEntities.LocationInvent;

import java.util.ArrayList;
import java.util.List;

public class PhysicalShopOrder implements PlacingOrder{

    List<Item> itemList = new ArrayList<>();
    public PhysicalShopOrder(String agentName, LocationInvent local, List<Item> item, int quantity)
    {

    }

    @Override
    public boolean processOrder(double prices, int quantity) {
        return false;
    }

    @Override
    public boolean addOrder(List<Item> item) {
        return false;
    }
}
