package com.toolRentalAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.toolRentalAPI.controllers.UserController;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@ComponentScan(basePackages="com.toolRentalApi.application")
@ComponentScan(basePackageClasses = UserController.class)
public class ToolRentalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolRentalApiApplication.class, args);
	}

	
}
