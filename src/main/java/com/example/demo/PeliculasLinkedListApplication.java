package com.example.demo;

import com.example.demo.model.ManipulacionArchivosI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeliculasLinkedListApplication{
	
	private Logger log = LoggerFactory.getLogger(PeliculasLinkedListApplication.class);

	@Autowired
	ManipulacionArchivosI manipulacionArchivosI;

	public static void main(String[] args) {
		SpringApplication.run(PeliculasLinkedListApplication.class, args);
	}

}
