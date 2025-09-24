package com.jtc.Inventory.Effeciency.inventController;


import com.jtc.Inventory.Effeciency.inventService.LocationService;
import com.jtc.Inventory.Effeciency.inventoryEntities.LocationInvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController
{
    @Autowired
    LocationService locationService;

    @GetMapping("/all")
    public ResponseEntity<List<LocationInvent>>getAllLocation()
    {
        return ResponseEntity.ok( locationService.getAllSave());
    }
}
