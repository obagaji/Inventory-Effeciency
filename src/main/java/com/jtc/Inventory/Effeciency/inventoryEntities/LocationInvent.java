package com.jtc.Inventory.Effeciency.inventoryEntities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.List;
import java.util.Set;

public class LocationInvent
{
    @Id
    private Integer locationId;
    private String name;
    private List<Item> itemList;
    private Set<ItemsSold> sellingItem;
    @Embedded.Nullable
    private StockTable stockTable;



}
