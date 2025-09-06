package com.jtc.Inventory.Effeciency.inventoryEntities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Component
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "items_sold")
public class ItemsSold {

    @Id
    @Column(value="items_sale_id")
    private int items_sale_id;
    @NonNull
    private double amount_paid;
    @Nullable
    private double discount_given;
    @Nullable
    private double change_given;
    @NonNull
    private double total_sales;
    @Nullable
    private int sales_agent_id;
    // will need to convert to date or change to local date time in the schema
    private Date sold_date_time;
    //TODO CHECK HOW TO ADD EMBEDDED CLASS TO THE SCHEMA
    private Set<OrderedItem> orderedItems = new HashSet<>();
    private AggregateReference<Customer, Integer>customerAggregate;
    private AggregateReference<Item, Integer> itemReference;

    public void getOrderedItem(OrderedItem orderedMade)
    {

     /*   if(orderedItems == null)
        {
            Set<OrderedItem> itemHashSet = new HashSet<>();
            orderedItems = itemHashSet;
        }*/
        orderedItems.add(orderedMade);
        orderedMade.itemsSold = this;
     //   return orderedItems;
    }





}
