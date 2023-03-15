package com.scrimfinderwq.scrimFinderWQ;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class ScrimFinderWqApplication{
	public static void main(String[] args) {
		SpringApplication.run(ScrimFinderWqApplication.class, args);
	}
}
