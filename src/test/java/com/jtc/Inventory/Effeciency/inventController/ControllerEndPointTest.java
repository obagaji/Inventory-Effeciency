package com.jtc.Inventory.Effeciency.inventController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtc.Inventory.Effeciency.inventDto.AddressTable;
import com.jtc.Inventory.Effeciency.inventUtility.UtilityClass;
import com.jtc.Inventory.Effeciency.inventoryEntities.Customer;
import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import com.jtc.Inventory.Effeciency.inventoryEntities.ItemsSold;
import com.jtc.Inventory.Effeciency.inventoryEntities.OrderedItem;
import com.jtc.Inventory.Effeciency.inventoryRepos.IntenCustomerRepo;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemRepository;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemSoldRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@WebMvcTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ControllerEndPointTest {

    @Autowired
    MockMvc mockMvc;
    private List<ItemsSold> itemList = new ArrayList<>();


    @Autowired
    IntenCustomerRepo intenCustomerRepo;
    @Autowired
    ItemRepository itemRepository;


    @Test
    void saveItemSold() throws Exception {
        //
        UtilityClass util = new UtilityClass();

        itemList = Stream.of(util.getItemsSold()).toList();

        //
        String items =  new ObjectMapper().writeValueAsString(itemList.get(0));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                                .content(items);
        mockMvc.perform(post("/save").content(items)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().json(items))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(document("home"));
    }
}
