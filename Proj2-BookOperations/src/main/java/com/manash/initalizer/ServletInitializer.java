package com.manash.initalizer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.manash.Proj2BookOperationsApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Proj2BookOperationsApplication.class);
	}

}
