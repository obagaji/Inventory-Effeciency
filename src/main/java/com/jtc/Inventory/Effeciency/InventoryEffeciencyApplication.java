package com.jtc.Inventory.Effeciency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
@EnableAutoConfiguration
public class InventoryEffeciencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryEffeciencyApplication.class, args);
	}

}
