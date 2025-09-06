package com.jtc.Inventory.Effeciency.inventController;


import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import com.jtc.Inventory.Effeciency.inventService.ItemService;
import com.jtc.Inventory.Effeciency.inventService.ItemsSoldServices;
import com.jtc.Inventory.Effeciency.inventoryEntities.Customer;
import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import com.jtc.Inventory.Effeciency.inventoryEntities.ItemsSold;
import com.jtc.Inventory.Effeciency.inventDto.SalesDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemInventController {

    private final ItemsSoldServices itemsSoldServices;
    private final ItemService itemService;


    @GetMapping("/sales/all")
    public ResponseEntity<List<ItemsSold>>getAll()
    {
        List<ItemsSold> itemsSolds = itemsSoldServices.findAllSale();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.ok().headers(headers).body(itemsSolds);
    }
    @GetMapping("/sales/maximum")
    public ResponseEntity<Double>salesMaximumForPeriod()
    {

        return ResponseEntity.ok().build();
    }
    @GetMapping("/sales/{id}")
    public ResponseEntity<SalesDetails>individualSalesDetails(@PathVariable("id") Integer salesIs)
    {
        SalesDetails salesDetails= itemsSoldServices.findSalesDetail(salesIs);
        return ResponseEntity.ok().body(salesDetails);
    }

    @GetMapping("/item")
    public ResponseEntity<List<Item>>saveItem()
    {
       List<Item> listItem= itemService.getAllItem();
       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("item").build(listItem);
       HttpHeaders header = new HttpHeaders();
       header.setLocation(uri);
        return ResponseEntity.ok().headers(header).body(listItem);
    }
    @PostMapping("/save")
    public ResponseEntity<Void>saveItemSold(@RequestBody ItemsSold itemsSold)
    {
        itemsSoldServices.addToSalesItem(itemsSold);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/item/id")
    public ResponseEntity<Item> getAllInfoAboutItem()
    {
        Item item = new Item();
        // this method will get all the information about a product.
        return ResponseEntity.ok(item);

    }

}
