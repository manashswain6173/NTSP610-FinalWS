package com.manash.msg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value="apps")
public class AppsMsg {
	
	public Map<String,String> appsMsg=new HashMap<String,String>();

	public Map<String, String> getAppsMsg() {
		return appsMsg;
	}

	public void setAppsMsg(Map<String, String> appsMsg) {
		this.appsMsg = appsMsg;
	}

}
 