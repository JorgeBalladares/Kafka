package com.example.EJ2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableMongoRepositories

public class Ej2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej2Application.class, args);
	}

}
