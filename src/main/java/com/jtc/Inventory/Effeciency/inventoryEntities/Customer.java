package com.jtc.Inventory.Effeciency.inventoryEntities;

import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Customer{

    @Id
    private Integer customer_id;
    private String customer_email;
    private String customer_age_range;
    private double totalPurchases;
    private double mostRecentPurchases;
  public Customer( String customer_email, String customer_age_range,
                       int totalPurchases, int mostRecentPurchases) {
}
//AddressTable address,

}