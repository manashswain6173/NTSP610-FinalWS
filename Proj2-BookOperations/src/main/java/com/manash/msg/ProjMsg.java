package com.manash.msg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value="apps")
public class ProjMsg {
	
	//create One map collection to store properties value
	public Map<String,Object> properties=new HashMap<String,Object>();


}
