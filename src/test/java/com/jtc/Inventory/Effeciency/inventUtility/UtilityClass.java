package com.jtc.Inventory.Effeciency.inventUtility;

import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import com.jtc.Inventory.Effeciency.inventoryEntities.*;
import com.jtc.Inventory.Effeciency.inventoryRepos.IntenCustomerRepo;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;


public class UtilityClass {

    @Autowired
    IntenCustomerRepo   intenCustomerRepo;
    @Autowired
    ItemRepository itemRepository;
/*
    AggregateReference<Customer, Integer> customerIntegerAggregateReference=AggregateReference.
            to(intenCustomerRepo.save(getCustomer()).getCustomer_id());
    AggregateReference<Item, Integer> itemIntegerAggregateReference = AggregateReference
            .to(itemRepository.save(getItem()).getItemProductId());
    AggregateReference<Item,Integer>locationAggregate = AggregateReference.to(itemRepository.save(getItem()).getItemProductId());*/
    public AddressTable getAddressTable()
    {
        String country = "Nigeria";
        String city =" Agatu";
        String street=" obagaji";
        AddressTable address = new AddressTable(country,city,street);
        return address;
    }
    public OrderedItem getOrderedItem()
    {
        OrderedItem orderedItem = new OrderedItem();
        orderedItem.setQuantity(200);
        orderedItem.setTimeOrdered(LocalDate.of(2021,6,22));
        orderedItem.setDeliveryAddress(getAddressTable());
        return orderedItem;
    }
    public Customer getCustomer()
    {
        return new Customer( "rqrrqqr",
                "@yahoo.com",23,33);
    }
    public Item getItem()
    {
        Item item = new Item();
        //item.setItemProductId(138);
        item.setItemDescription("New Big bag");
        item.setItemName(" small bag");
        item.setItemExpirationDate(new java.util.Date(System.currentTimeMillis()));
        item.setItemQuantityInStock(1001);
        item.setDate_time_in(new java.util.Date(System.currentTimeMillis()));
        item.setCurrent_date_time(new java.util.Date(System.currentTimeMillis()));
        item.setItemSellingPrice(33.22);
        return item;
    }
    public ItemsSold getItemsSold()
    {

        ItemsSold itemsSold = new ItemsSold();
        itemsSold.getOrderedItem(getOrderedItem());
        //  itemsSold.setItems_sale_id(3233);
        itemsSold.setAmount_paid(20);
        itemsSold.setChange_given(0.0);
        itemsSold.setDiscount_given(0.00);
       // itemsSold.setCustomerAggregate(customerIntegerAggregateReference);
        itemsSold.setTotal_sales(200);
        itemsSold.setSales_agent_id(100);
        itemsSold.setSold_date_time(new Date(2025));
     //   itemsSold.setItemReference(itemIntegerAggregateReference);
        return itemsSold;
    }
    public LocationInvent getLocationDate()
    {
        LocationInvent location = new LocationInvent();
        location.setLocationId(10);
        location.setLocation_name("Ojo");
        location.setDateItemIn(LocalDate.of(2025,10,22));
        location.setCurrentDateTime(LocalDate.now());
        location.setItemAvailableQuantity(20);
        location.setPossibleOutStockDate(LocalDate.of(2025,11,12));
    //    location.setItemReference(locationAggregate);
        return location;
    }
}
