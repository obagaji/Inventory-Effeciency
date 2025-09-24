package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventUtility.UtilityClass;
import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import com.jtc.Inventory.Effeciency.inventoryEntities.LocationInvent;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;

//@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
@SpringBootTest
public class LocationServiceTest
{
    @Autowired
    LocationService locations;

    @Autowired
    ItemRepository itemRepository;
    Item item = new Item();
    LocationInvent location = new LocationInvent();
  @BeforeEach
  public void setup()
  {

      item.setItemDescription("New Big bag");
      item.setItemName(" small bag");
      item.setItemExpirationDate(new java.util.Date(System.currentTimeMillis()));
      item.setItemQuantityInStock(1001);
      item.setDate_time_in(new java.util.Date(System.currentTimeMillis()));
      item.setCurrent_date_time(new java.util.Date(System.currentTimeMillis()));
      item.setItemSellingPrice(33.22);
      AggregateReference<Item,Integer> locationAggregate = AggregateReference.to(itemRepository.save(item).getItemProductId());
      location.setLocationId(10);
      location.setLocation_name("ojo");
      location.setDateItemIn(LocalDate.of(2025,10,22));
      location.setCurrentDateTime(LocalDate.now());
      location.setItemAvailableQuantity(20);
      location.setPossibleOutStockDate(LocalDate.of(2025,11,12));
      location.setItemIdReference(locationAggregate);

  }

    @DisplayName(" Saving  Aggregate Location ")
    @Test
    void locationTest()
    {
           assertSame(locations.saveLocation(location),location);

    }

}
