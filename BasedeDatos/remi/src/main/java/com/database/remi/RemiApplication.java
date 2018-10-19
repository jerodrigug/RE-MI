package com.database.remi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


import javax.annotation.PostConstruct;
import java.util.TimeZone;






@SpringBootApplication
@EntityScan(basePackageClasses = { 
	RemiApplication.class,
	Jsr310JpaConverters.class 
})
@EnableJpaAuditing
public class RemiApplication {
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}


	public static void main(String[] args) {
		SpringApplication.run(RemiApplication.class, args);
	}
}
