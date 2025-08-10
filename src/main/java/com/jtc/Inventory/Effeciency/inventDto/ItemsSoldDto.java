package com.jtc.Inventory.Effeciency.inventDto;

public record ItemsSoldDto( int items_sale_id, int customer_id,double amount_paid, double discount_given,
                            double total_sales, int sales_agent_id) {

}
