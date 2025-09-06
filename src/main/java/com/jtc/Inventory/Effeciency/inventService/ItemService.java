package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final JdbcAggregateTemplate template;

    public void ItemSave(Item item)
    {
        template.insert(item);

        //itemRepository.save(item);
    }

    public List<Item> getAllItem()
    {
        return (List<Item>) itemRepository.findAll();
    }

}
