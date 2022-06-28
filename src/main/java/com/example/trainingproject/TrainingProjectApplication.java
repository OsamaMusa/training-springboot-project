package com.example.trainingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TrainingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingProjectApplication.class, args);
	}

}
