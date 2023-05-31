package com.finalback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com")
@ComponentScan("com")
@EnableJpaRepositories("com.dao")
public class UscApplication {

	public static void main(String[] args) {
		SpringApplication.run(UscApplication.class, args);
	}

}
