package org.sid.inventoryservice;

import org.sid.inventoryservice.dto.ProductRequestDto;
import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepo;
import org.sid.inventoryservice.services.ProductServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductServices productServices){
		return args -> {
			for (int i = 0; i < 8; i++) {
				ProductRequestDto productRequestDto = ProductRequestDto.builder()
						.name("Computer"+i)
						.price(Math.random() * 999)
						.quantity((int)(Math.random()*50))
						.build();

				productServices.save(productRequestDto);
			}
		};
	}

}
