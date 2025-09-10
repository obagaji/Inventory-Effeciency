package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import com.jtc.Inventory.Effeciency.inventoryEntities.*;
import com.jtc.Inventory.Effeciency.inventoryRepos.IntenCustomerRepo;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemRepository;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemSoldRepository;
import com.jtc.Inventory.Effeciency.inventoryRepos.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


//@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})

@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class ItemInventControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;
    @Autowired
    MockMvcConfigurer mockMvcConfigurer;
    @Autowired
    IntenCustomerRepo intenCustomerRepo;
    @Autowired
    ItemSoldRepository itemSoldRepository;
    private List<ItemsSold> itemList = new ArrayList<>();
    @Autowired
    JdbcAggregateTemplate aggregateTemplate;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    LocationRepository locationRepository;


    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp()
    {
        AddressTable address = new AddressTable("nigeria","benue","Agatu");
        Customer customer =new Customer( "rqrrqqr","@yahoo.com",23,33);
        Item item = new Item();
        //item.setItemProductId(138);
        item.setItemDescription(" Big bag");
        item.setItemName("bag");
        item.setItemExpirationDate(new java.util.Date(System.currentTimeMillis()));
        item.setItemQuantityInStock(100);
        item.setDate_time_in(new java.util.Date(System.currentTimeMillis()));
        item.setCurrent_date_time(new java.util.Date(System.currentTimeMillis()));
        item.setItemSellingPrice(33.22);
        AggregateReference<Customer, Integer> customerIntegerAggregateReference=AggregateReference.to(intenCustomerRepo
                .save(customer).getCustomer_id());
        AggregateReference<Item, Integer> itemIntegerAggregateReference = AggregateReference.to(itemRepository.save(item).getItemProductId());
        OrderedItem orderedItem = new OrderedItem();
        orderedItem.setQuantity(200);
        orderedItem.setTimeOrdered( new Date(2021,6,22));
        orderedItem.setDeliveryAddress(address);
        ItemsSold itemsSold = new ItemsSold();
        itemsSold.getOrderedItem(orderedItem);
      //  itemsSold.setItems_sale_id(3233);
        itemsSold.setAmount_paid(20);
        itemsSold.setChange_given(0.0);
        itemsSold.setDiscount_given(0.00);
        itemsSold.setCustomerAggregate(customerIntegerAggregateReference);
        itemsSold.setTotal_sales(200);
        itemsSold.setSales_agent_id(100);
        itemsSold.setSold_date_time(new Date(2025));
        itemsSold.setItemReference(itemIntegerAggregateReference);
        itemList = Stream.of(itemsSold).toList();

    }

    @Test
    void customerIdTest()
    {
        Customer customer =new Customer("rqrrqqr","@yahoo.com",23,33);
        assertThat(customer.getCustomer_id()).isNull();
    }

    @Test
    void saveItem()  {
        assertSame(itemList.get(0),itemSoldRepository.save(itemList.get(0)));
    }
    @Test
    @DisplayName("Save the location data")
    void saveLocation()
    {
    /*    LocationInvent locationInvent = new LocationInvent();
        assertSame(locationInvent,locationRepository.save(locationInvent));*/
    }

}