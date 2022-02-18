package com.exemple.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringWeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeatherServiceApplication.class, args);
	}
}
