package com.manash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.manash.config.WebMvcConfig;

@SpringBootApplication
@Import(WebMvcConfig.class)
public class Proj2BookOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj2BookOperationsApplication.class, args);
	}

}
