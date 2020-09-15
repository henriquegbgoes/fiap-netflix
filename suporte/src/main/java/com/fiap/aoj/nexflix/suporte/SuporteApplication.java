package com.fiap.aoj.nexflix.suporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SuporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuporteApplication.class, args);
	}

}
