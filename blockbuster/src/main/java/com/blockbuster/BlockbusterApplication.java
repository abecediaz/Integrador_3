package com.blockbuster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockbusterApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8080");
		SpringApplication.run(BlockbusterApplication.class, args);
	}

}
