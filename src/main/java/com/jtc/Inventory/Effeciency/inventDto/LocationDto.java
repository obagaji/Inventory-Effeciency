package com.jtc.Inventory.Effeciency.inventDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record LocationDto(String location_name, Integer item_total, String item_name,
                          LocalDate item_date_in, Integer out_rate, LocalDateTime possible_out_stock_date)
{
}
