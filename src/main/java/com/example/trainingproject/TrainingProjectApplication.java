package com.example.trainingproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "LogesTech  APIs", version = "1.0" , description = "This APIs for traning session."))
public class TrainingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingProjectApplication.class, args);
	}

}
