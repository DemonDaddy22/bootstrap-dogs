package com.udacity.dogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class DogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogsApplication.class, args);
	}

}
