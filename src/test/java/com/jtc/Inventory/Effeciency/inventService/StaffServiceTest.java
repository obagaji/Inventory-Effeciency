


package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import com.jtc.Inventory.Effeciency.inventoryEntities.Staff;
import com.jtc.Inventory.Effeciency.inventoryRepos.StaffRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*@DataJdbcTest
@ExtendWith(SpringExtension.class)*/
@SpringBootTest
public class StaffServiceTest {
    @Autowired
    StaffService staffService;
    @Autowired
    JdbcAggregateTemplate aggregateTemplate;

    @Autowired
    StaffRepo staffRepo;
    AddressTable addressTable = new AddressTable("Nigeria","Lagos","20 Olaoye Stree");

    private final Staff staff = new Staff("musa",
            "jtc@musa","male",addressTable);


    @Test
    public void setStaff()
    {
        String s = staff.getName();
        staff.setStaffId(123);
        aggregateTemplate.insert(staff);
        assertEquals(s,staffService.getStaffNameWithId(123));
    }
    @Test
    public void saveTest()
    {
     //
        assertThat(staff.getStaffId()).isNull();
    }
  
}


