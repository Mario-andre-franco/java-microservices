package com.mariodev.hrouth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrOuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrOuthApplication.class, args);
	}

}
