package com.praveenellaiyan.springconfigserverpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringConfigServerPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigServerPracticeApplication.class, args);
	}

}
