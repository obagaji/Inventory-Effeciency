package com.jtc.Inventory.Effeciency.inventoryRepos;

import com.jtc.Inventory.Effeciency.inventoryEntities.Staff;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StaffRepo extends CrudRepository<Staff, Integer>
{
    @Query("Select name from Staff where staff_Id=:id")
    String findByStaffId(@Param("id") Integer id);

    @Query("select s from staff s")
    List<Staff> findAllStaff();

}
