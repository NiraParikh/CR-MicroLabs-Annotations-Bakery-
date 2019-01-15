package com.zipcodewilmington.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.zipcodewilmington.bakery.Repositories")
@EntityScan("com.zipcodewilmington.bakery.models")
@SpringBootApplication
public class BakeryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class, args);
	}
}
