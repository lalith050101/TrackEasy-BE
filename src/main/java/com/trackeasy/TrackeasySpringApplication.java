package com.trackeasy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

@SpringBootApplication
@EnableScheduling
public class TrackeasySpringApplication {


	  public static final Logger logger = LoggerFactory.getLogger("com.trackeasy.firebase");
	public static void main(String[] args) {
		SpringApplication.run(TrackeasySpringApplication.class, args);
	}
	
	 @Bean
	  public WebClient webClient() {
	    return WebClient.create();
	  }

}
