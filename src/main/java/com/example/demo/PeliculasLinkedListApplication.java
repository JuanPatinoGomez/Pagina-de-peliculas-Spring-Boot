package com.example.demo;

import java.util.LinkedList;

import com.example.demo.model.ArchivoException;
import com.example.demo.model.ManipulacionArchivosI;
import com.example.demo.model.Pelicula;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeliculasLinkedListApplication implements CommandLineRunner{
	
	private Logger log = LoggerFactory.getLogger(PeliculasLinkedListApplication.class);

	@Autowired
	ManipulacionArchivosI manipulacionArchivosI;

	public static void main(String[] args) {
		SpringApplication.run(PeliculasLinkedListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// log.info("Mensaje informativo");

		// try{

		// 	log.info("escribirrrr");
		// 	manipulacionArchivosI.escribir(listadoDePeliculas());
		// 	manipulacionArchivosI.leer();
		// }catch(ArchivoException e){


		// 	log.error(e.getMessage());
		// }
		
	}

	public LinkedList<Pelicula> listadoDePeliculas(){

		LinkedList<Pelicula> peliculas = new LinkedList<>();

		peliculas.add(new Pelicula("Venom: Carnage liberado", "Acción/Ciencia ficción", 
		"Después de encontrar un cuerpo anfitrión en el periodista de investigación Eddie Brock, el simbionte alienígena debe enfrentarse a un nuevo enemigo, Carnage, el alter ego del asesino en serie Cletus Kasady.", 
		"https://archivos-cms.cinecolombia.com/images/_aliases/exhibition_banner_mobile/5/4/1/1/21145-1-esl-CO/VNM2-6-Banner-movil.jpg"));
		peliculas.add(new Pelicula("Duna", "Ciencia ficción/Aventura",
		"Arrakis, también denominado \"Dune\", se ha convertido en el planeta más importante del universo. A su alrededor comienza una gigantesca lucha por el poder que culmina en una guerra interestelar.",
		"https://archivos-cms.cinecolombia.com/images/_aliases/exhibition_banner_mobile/8/3/9/0/20938-1-esl-CO/800x600.jpg"));

		return peliculas;

	}

}
