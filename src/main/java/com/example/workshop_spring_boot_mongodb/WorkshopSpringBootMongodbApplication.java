package com.example.workshop_spring_boot_mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.workshop_spring_boot_mongodb.repositories")
public class WorkshopSpringBootMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopSpringBootMongodbApplication.class, args);
	}

}
