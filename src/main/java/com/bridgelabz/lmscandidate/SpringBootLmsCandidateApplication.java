package com.bridgelabz.lmscandidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.bridgelabz.lmscandidate")
@EnableJpaRepositories("com.bridgelabz.lmscandidate.respository")
@EnableEurekaClient
public class SpringBootLmsCandidateApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLmsCandidateApplication.class, args);
	}

}
