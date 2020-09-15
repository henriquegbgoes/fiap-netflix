package com.fiap.aoj.nexflix.titulo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TituloApplication {

	public static void main(String[] args) {
		SpringApplication.run(TituloApplication.class, args);
	}

}
