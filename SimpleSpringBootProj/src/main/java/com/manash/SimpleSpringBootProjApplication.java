package com.manash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.manash.config.WebMvcConfig;

@SpringBootApplication
@Import(WebMvcConfig.class)
public class SimpleSpringBootProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootProjApplication.class, args);
	}

}
