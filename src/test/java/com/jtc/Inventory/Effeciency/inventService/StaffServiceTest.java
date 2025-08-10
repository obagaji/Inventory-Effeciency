/*


package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import com.jtc.Inventory.Effeciency.inventoryEntities.Staff;
import com.jtc.Inventory.Effeciency.inventoryRepos.StaffRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@ExtendWith(SpringExtension.class)
public class StaffServiceTest {
    @Autowired
    StaffService staffService;

    @Autowired
    StaffRepo staffRepo;
    AddressTable addressTable = new AddressTable("Nigeria","Lagos","20 Olaoye Stree");

    private Staff staff = new Staff(123,"musa",
            "jtc@musa","male",addressTable,"admin");

    @Test
    public void setStaff()
    {
        String s = staff.getStaffName();
        assertEquals(s,staffService.getStaffNameWithId(123));
    }
    @Test
    public void saveTest()
    {
        var d =staffRepo.save(staff);
        assertThat(d).isNotNull();
    }
  
}

*/
