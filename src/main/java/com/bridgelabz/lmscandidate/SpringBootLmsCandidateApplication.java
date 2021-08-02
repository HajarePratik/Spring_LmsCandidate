package com.bridgelabz.lmscandidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.bridgelabz.lmscandidate")
@EnableJpaRepositories("com.bridgelabz.lmscandidate.respository")
public class SpringBootLmsCandidateApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLmsCandidateApplication.class, args);
	}

}
