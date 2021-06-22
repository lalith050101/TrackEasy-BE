package com.trackeasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

@SpringBootApplication

public class TrackeasySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackeasySpringApplication.class, args);
	}

}
