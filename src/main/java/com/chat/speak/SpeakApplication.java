package com.chat.speak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.chat.speak"})
@EntityScan("com.chat.speak.model")
@EnableJpaRepositories(basePackages = {"com.chat.speak.repository"})
@SpringBootApplication
public class SpeakApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakApplication.class, args);
	}
}
