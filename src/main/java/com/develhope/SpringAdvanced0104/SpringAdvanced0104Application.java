package com.develhope.SpringAdvanced0104;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAdvanced0104Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdvanced0104Application.class, args);
	}

}
/*

	test the endpoints with Postman:
		for provisioning without the n query parameter
		for provisioning with the n query parameter, with value 49
		for getting the flights using pagination
		for getting the flights that are ONTIME
		for getting the delayed or cancelled flights
		for getting the on time or delayed flights*/
