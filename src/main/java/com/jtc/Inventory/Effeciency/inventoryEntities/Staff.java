package com.jtc.Inventory.Effeciency.inventoryEntities;

import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @Id
    Integer staffId;
    String staffName;
    String staffEmail;
    String sex;
    @Embedded.Nullable
    AddressTable address;
    StaffRole role;


}
