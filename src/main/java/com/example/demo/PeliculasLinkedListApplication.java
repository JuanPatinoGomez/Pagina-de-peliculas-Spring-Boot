package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeliculasLinkedListApplication implements CommandLineRunner{
	
	private Logger log = LoggerFactory.getLogger(PeliculasLinkedListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PeliculasLinkedListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("Mensaje informativo");
	}

}
