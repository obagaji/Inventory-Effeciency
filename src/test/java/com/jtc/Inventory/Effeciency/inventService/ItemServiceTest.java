package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    JdbcAggregateTemplate jdbcAggregateTemplate;
    @Autowired
    ItemRepository itemRepository;

    @Test
    void saveItem()
    {
        Item item = new Item();
        item.setItemProductId(2);
        item.setItemDescription(" Big bag");
        item.setItemName("bag");
        item.setItemExpirationDate(new Date(System.currentTimeMillis()));
        item.setItemQuantityInStock(100);
        item.setDate_time_in(new Date(System.currentTimeMillis()));
        item.setCurrent_date_time(new Date(System.currentTimeMillis()));
        item.setItemSellingPrice(33.22);
        jdbcAggregateTemplate.insert(item);
        assertThat(itemRepository.findAll()).hasSize(5);


    }
}
