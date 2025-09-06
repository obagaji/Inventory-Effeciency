package com.jtc.Inventory.Effeciency.inventoryRepos;

import com.jtc.Inventory.Effeciency.inventDto.LocationDto;
import com.jtc.Inventory.Effeciency.inventoryEntities.LocationInvent;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LocationRepository extends ListCrudRepository<LocationInvent, Integer>
{

    @Query("select location_name,item_total,item_name,item_date_in,out_rate,possible_out_stock_date from location_table" +
            "where location_id = ?")
    public Optional<LocationDto> findByLocationId(@Param("location_id") Integer locationId);
}

