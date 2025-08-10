package com.jtc.Inventory.Effeciency.inventoryEntities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item_table")
public class Item {

    @Id
    private Integer itemProductId;
    private String itemDescription;
    private int itemQuantityInStock;
    private String itemName;
    private Date itemExpirationDate;
    private double itemSellingPrice;


}
