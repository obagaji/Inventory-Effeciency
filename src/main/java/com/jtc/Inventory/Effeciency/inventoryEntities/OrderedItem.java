package com.jtc.Inventory.Effeciency.inventoryEntities;

import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import com.jtc.Inventory.Effeciency.inventEnums.DelieveryEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.LocalDateTime;
import java.util.Date;

//@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderedItem
{
    private int quantity;
    private Date timeOrdered;
    @Embedded.Nullable
    private AddressTable deliveryAddress;
  //  private String deliveryStatus;
    @Transient
    ItemsSold itemsSold;
}
