package com.intocomunity.api;

import com.intocomunity.api.security.DiscordOAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
	//	String scope[] = {"indentify"};
	//	DiscordOAuth oauthHandler = new DiscordOAuth("788516512600293426", "inqQYwCMWNW9oRU6gl8zG_abUFpWU86w ",  scope);

		SpringApplication.run(ApiApplication.class, args);
	}

}
