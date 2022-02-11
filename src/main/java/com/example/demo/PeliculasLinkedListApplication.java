package com.example.demo;

import com.example.demo.model.ManipulacionArchivosI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeliculasLinkedListApplication{
	

	@Autowired
	ManipulacionArchivosI manipulacionArchivosI;

	public static void main(String[] args) {
		SpringApplication.run(PeliculasLinkedListApplication.class, args);
	}

}
