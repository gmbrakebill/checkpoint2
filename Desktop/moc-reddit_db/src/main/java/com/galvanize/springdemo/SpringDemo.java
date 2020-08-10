package com.galvanize.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@SpringBootApplication
public class SpringDemo {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo.class, args);
//		System.out.println("JDBC_DB_URL: " + System.getenv("JDBC_DB_URL"));
//		System.out.println("JDBC_DB_USER: " + System.getenv("JDBC_DB_USER"));
//		System.out.println("JDBC_DB_PASS: " + System.getenv("JDBC_DB_PASS"));
	}

}
