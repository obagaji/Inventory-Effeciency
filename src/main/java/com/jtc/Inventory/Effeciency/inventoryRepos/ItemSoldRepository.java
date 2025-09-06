package com.jtc.Inventory.Effeciency.inventoryRepos;

import com.jtc.Inventory.Effeciency.inventoryEntities.ItemsSold;
import com.jtc.Inventory.Effeciency.inventDto.SalesDetails;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ItemSoldRepository extends CrudRepository<ItemsSold, Integer>
{
/*
    @Query("INSERT INTO customer_id, amount_paid, total_sales,sales_agent_id from sales_table where items_sale_id = items_sale_id")
    Optional<SalesDetails> getSalesDetails(@Param("sale_id") int sale_id);*/

    // query method to determine the customer with the highest purchase for the year.
  /*  @Query(" select customer_id from sales_table where total_sales=(select max(total_sales) from sales_table")
    public int getTheMaximumPurchase();*/






}

