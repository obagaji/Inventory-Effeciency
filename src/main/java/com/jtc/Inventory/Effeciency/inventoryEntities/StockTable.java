package com.jtc.Inventory.Effeciency.inventoryEntities;

import java.time.LocalDateTime;

public record StockTable (Integer itemTotal, String ItemName, LocalDateTime itemDateIn, Integer outRate, Integer possibleOutStocked)
{
}
