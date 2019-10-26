package com.manash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.manash.config.RootAppConfig;
import com.manash.config.WebMvcConfig;

@SpringBootApplication
@Import({WebMvcConfig.class,RootAppConfig.class})
public class Proj2InsertBookDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj2InsertBookDetailsApplication.class, args);
	}

}
