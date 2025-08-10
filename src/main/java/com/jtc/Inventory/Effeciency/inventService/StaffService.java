package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventoryEntities.Staff;
import com.jtc.Inventory.Effeciency.inventoryRepos.StaffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffService
{
   // @Autowired
    private final Staff staffForService;
 //  @Autowired
 private final StaffRepo staffRepo;
    public List<Staff> listOfStaff()
    {
        return staffRepo.findAllStaff();
    }
     public String getStaffNameWithId(Integer id)
    {
        String value = "No value";
        Optional<String> optionalString = Optional.ofNullable(staffRepo.findByStaffId(id));
        if (optionalString.isPresent()) {
            value = optionalString.get();
        }
        return value;
    }
}
