package com.jtc.Inventory.Effeciency.inventController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import com.jtc.Inventory.Effeciency.inventEnums.DelieveryEnum;
import com.jtc.Inventory.Effeciency.inventoryEntities.Customer;
import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import com.jtc.Inventory.Effeciency.inventoryEntities.ItemsSold;
import com.jtc.Inventory.Effeciency.inventoryEntities.OrderedItem;
import com.jtc.Inventory.Effeciency.inventoryRepos.IntenCustomerRepo;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemRepository;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemSoldRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


//@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
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
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp()//WebApplicationContext webContext, RestDocumentationExtension restDocumentationExtension)
    {
       // this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).apply(mockMvcConfigurer).build();
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
        Set<OrderedItem> setOrderedItem = Set.of(orderedItem);
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

    /*    AddressTable secondAddress = new AddressTable("nigeria","lagos","Olaoye");
        Customer secondCustomer = new Customer("musa", address,"rqrrqqr","@yahoo.com",23.00,33.00);
        ItemsSold secondItemsSold = new ItemsSold(120,customer,
                20,0,0,210,22, new Date(2019,2,30));

        AddressTable thirdAddress = new AddressTable("nigeria","PH","Olaoye");
        Customer thirdCustomer = new Customer("musa", address,"rqrrqqr","@yahoo.com",23.00,33.00);
        ItemsSold thirdItemsSold = new ItemsSold(121,customer,
                20,0,0,9920,22, new Date(1990,2,30));*/
        itemList = Stream.of(itemsSold).toList();

    }

    @Test
    void idTest()
    {
        Customer customer =new Customer("rqrrqqr","@yahoo.com",23,33);
        assertThat(customer.getCustomer_id()).isNull();
    }

    @Test
    void saveItem()  {
    //    aggregateTemplate.insert(itemList.get(0));

        assertSame(itemList.get(0),itemSoldRepository.save(itemList.get(0)));
    }

   /* @Test
    void saveItemSold() throws Exception {
        String items =  new ObjectMapper().writeValueAsString(itemList);
        *//*RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                                .content(items);*//*
        mockMvc.perform(post("/save").content(items)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(items))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }*/
}