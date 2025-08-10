package com.jtc.Inventory.Effeciency.inventDto;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;

import java.util.HashMap;
import java.util.List;

public record ItemSoldQuantity(List<Item> items, int quantity)
{
    public HashMap<Item, Integer>quentitySold(List<Item> items, List<Integer> numbers)
    {
       HashMap<Item, Integer> result = new HashMap<>();
        for (int i=0; i< items.size(); i++)
        {
            result.put(items.get(i),numbers.get(i));
        }
        return result;
    }

}
