package com.jtc.Inventory.Effeciency.inventoryEntities;

import java.time.LocalDateTime;

public record MonthlyTotalSale(Integer itemId, LocalDateTime endMonthDate,
                               int itemTotal, double percentageTotalMonth, double monthlyTotalSales) {
}
