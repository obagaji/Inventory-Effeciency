package com.jtc.Inventory.Effeciency.inventoryRepos;

import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer>
{

}
