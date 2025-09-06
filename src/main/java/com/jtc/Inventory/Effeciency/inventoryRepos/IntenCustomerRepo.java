package com.jtc.Inventory.Effeciency.inventoryRepos;

import com.jtc.Inventory.Effeciency.inventoryEntities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface IntenCustomerRepo extends CrudRepository<Customer,Integer> {
}
