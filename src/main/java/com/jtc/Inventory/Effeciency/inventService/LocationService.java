package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import com.jtc.Inventory.Effeciency.inventoryEntities.LocationInvent;
import com.jtc.Inventory.Effeciency.inventoryRepos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService
{
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    JdbcAggregateTemplate aggregateTemplate;

    public LocationInvent saveLocation(LocationInvent locationInvent)
    {
        return aggregateTemplate.insert(locationInvent);
    }
    public List<LocationInvent> getAllSave()
    {
        return locationRepository.findAll();
    }

}
