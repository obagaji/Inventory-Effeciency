package com.jtc.Inventory.Effeciency.inventDto;

import com.jtc.Inventory.Effeciency.inventoryEntities.Category;
import com.jtc.Inventory.Effeciency.inventoryEntities.MonthlyTotalSale;
import com.jtc.Inventory.Effeciency.inventoryEntities.StockTable;

import java.util.Date;

public record ItemDto(Integer itemProductId,
                      String itemDescription,
                      int itemQuantityInStock,
                      String itemName,
                      Date itemExpirationDate,
                      double itemSellingPrice,
                      Date current_date_time,
                      Date date_time_in,
                      StockTable stockTable,
                      MonthlyTotalSale monthTotal,
                      Category category) {
}
