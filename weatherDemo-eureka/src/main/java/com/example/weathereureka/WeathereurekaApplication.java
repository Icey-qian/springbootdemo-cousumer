package com.example.weathereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WeathereurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeathereurekaApplication.class, args);
	}

}
