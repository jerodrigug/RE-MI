package com.database.remi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class RemiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemiApplication.class, args);
	}
}
