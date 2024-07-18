package com.rj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Ms12RabbitMqJavaGuidesPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms12RabbitMqJavaGuidesPublisherApplication.class, args);
	}

}
