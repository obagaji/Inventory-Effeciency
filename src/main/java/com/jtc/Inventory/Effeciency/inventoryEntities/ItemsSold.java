package com.jtc.Inventory.Effeciency.inventoryEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.sql.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sales_table")
public class ItemsSold {

    @Id
    @Column(value="items_sale_id")
    private int items_sale_id;
    private Customer customer;
    private double amount_paid;
    private double discount_given;
    private double change_given;
    private double total_sales;
    private int sales_agent_id;
    // will need to convert to date or change to local date time in the schema

    private Date sold_date_time;
    //TODO CHECK HOW TO ADD EMBEDDED CLASS TO THE SCHEMA
  /*  @Embedded.Nullable
    private ItemSoldQuantity listOfItems;*/

}
