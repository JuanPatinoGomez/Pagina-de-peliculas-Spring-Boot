package com.example.demo.model;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InformacionImpl implements InformacionI{

	Logger log = LoggerFactory.getLogger(InformacionImpl.class);

	
	private int contadorId = 0;

	@Autowired
	private ManipulacionArchivosI manipulacionArchivosI;
	
	
	public void peliculasIniciales() {
		
		if(this.traerPeliculas().size() == 0) {
			
			// agregarPelicula(new Pelicula("Venom: Carnage liberado", "Acción/Ciencia ficción", 
			// 		"Después de encontrar un cuerpo anfitrión en el periodista de investigación Eddie Brock, el simbionte alienígena debe enfrentarse a un nuevo enemigo, Carnage, el alter ego del asesino en serie Cletus Kasady.", 
			// 		"https://archivos-cms.cinecolombia.com/images/_aliases/exhibition_banner_mobile/5/4/1/1/21145-1-esl-CO/VNM2-6-Banner-movil.jpg"));
			
			// agregarPelicula(new Pelicula("Duna", "Ciencia ficción/Aventura",
			// 		"Arrakis, también denominado \"Dune\", se ha convertido en el planeta más importante del universo. A su alrededor comienza una gigantesca lucha por el poder que culmina en una guerra interestelar.",
			// 		"https://archivos-cms.cinecolombia.com/images/_aliases/exhibition_banner_mobile/8/3/9/0/20938-1-esl-CO/800x600.jpg"));
			
			// agregarPelicula(new Pelicula("Ron da error", "Animación/cine familiar",
			// 		"Barney, un niño de 11 años, descubre que su amigo robot no funciona del todo porque ha sido dañado durante el transporte para su entrega.",
			// 		"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2021/10/ron-da-error-2507269.jpg?itok=8RO4smVL"));
			
			// agregarPelicula(new Pelicula("Los locos Addams 2", "Animación/Fantasía",
			// 		"Morticia da a luz a un bebé, y la familia le pone un nombre: Pubis. Sus hermanos, Miércoles y Pugsley, pronto sienten celos del recién nacido e intentan acabar con él.",
			// 		"https://i1.wp.com/modogeeks.com/wp-content/uploads/2020/10/locos-addams-2.jpg?fit=958%2C773&ssl=1"));
			
			// agregarPelicula(new Pelicula("Sin tiempo para morir", "Acción/Aventura",
			// 		"EL legendario espía James Bond ha dejado el servicio activo. Su paz dura poco ya que su viejo amigo Felix Leiter de la CIA aparece pidiendo ayuda, lo que lleva a Bond al rastro de un misterioso villano armado con nueva tecnología peligrosa.",
			// 		"https://media.vandalsports.com/i/640x360/10-2021/2021104172234_1.jpg"));

			LinkedList<Pelicula> peliculas = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula("Venom: Carnage liberado", "Acción/Ciencia ficción", 
			"Después de encontrar un cuerpo anfitrión en el periodista de investigación Eddie Brock, el simbionte alienígena debe enfrentarse a un nuevo enemigo, Carnage, el alter ego del asesino en serie Cletus Kasady.", 
			"https://archivos-cms.cinecolombia.com/images/_aliases/exhibition_banner_mobile/5/4/1/1/21145-1-esl-CO/VNM2-6-Banner-movil.jpg");

			pelicula1.setId(this.contadorId);

			this.contadorId++;

			Pelicula pelicula2 = new Pelicula("Duna", "Ciencia ficción/Aventura",
			"Arrakis, también denominado \"Dune\", se ha convertido en el planeta más importante del universo. A su alrededor comienza una gigantesca lucha por el poder que culmina en una guerra interestelar.",
			"https://archivos-cms.cinecolombia.com/images/_aliases/exhibition_banner_mobile/8/3/9/0/20938-1-esl-CO/800x600.jpg");

			pelicula2.setId(this.contadorId);
			
			this.contadorId++;

			Pelicula pelicula3 = new Pelicula("Ron da error", "Animación/cine familiar",
			"Barney, un niño de 11 años, descubre que su amigo robot no funciona del todo porque ha sido dañado durante el transporte para su entrega.",
			"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2021/10/ron-da-error-2507269.jpg?itok=8RO4smVL");

			pelicula3.setId(this.contadorId);

			this.contadorId++;

			Pelicula pelicula4 = new Pelicula("Los locos Addams 2", "Animación/Fantasía",
			"Morticia da a luz a un bebé, y la familia le pone un nombre: Pubis. Sus hermanos, Miércoles y Pugsley, pronto sienten celos del recién nacido e intentan acabar con él.",
			"https://i1.wp.com/modogeeks.com/wp-content/uploads/2020/10/locos-addams-2.jpg?fit=958%2C773&ssl=1");
			
			pelicula4.setId(this.contadorId);

			this.contadorId++;

			Pelicula pelicula5 = new Pelicula("Sin tiempo para morir", "Acción/Aventura",
			"EL legendario espía James Bond ha dejado el servicio activo. Su paz dura poco ya que su viejo amigo Felix Leiter de la CIA aparece pidiendo ayuda, lo que lleva a Bond al rastro de un misterioso villano armado con nueva tecnología peligrosa.",
			"https://media.vandalsports.com/i/640x360/10-2021/2021104172234_1.jpg");

			pelicula5.setId(this.contadorId);

			this.contadorId++;


			peliculas.add(pelicula1);
			peliculas.add(pelicula2);
			peliculas.add(pelicula3);
			peliculas.add(pelicula4);
			peliculas.add(pelicula5);

			try{

				this.manipulacionArchivosI.escribir(peliculas);

			}catch(ArchivoException e){

				this.log.error(e.getMessage());

			}

			
		
		}else{
			this.contadorId = this.traerPeliculas().getLast().getId() + 1; 
			//Se trae el id del ultimo elemento y se le suma uno para cuando se agrege otra pelicula continue la secuencia
		}
		
	}
	
	
	public boolean agregarPelicula(Pelicula pelicula) {
		
		pelicula.setId(contadorId); //Se le agrega el id
		
		contadorId++; //El id que tendra la siguiente pelicula

		try {
			
			//Se agrega en el archivo
			this.manipulacionArchivosI.agregarPeli(pelicula);
			return true;

		} catch (ArchivoException e) {

			log.error(e.getMessage());
			return false;
		}
				
	}
	
	public boolean eliminarPelicula(int id) {

		//Traemos las peliculas que esten en el archivo
		LinkedList<Pelicula> peliculasDepu = this.traerPeliculas();
		
		
		for(Pelicula pelicula : peliculasDepu) {
			
			if(pelicula.getId() == id) {

				//Eliminamos del linkedlist la que contenga el mismo id
				peliculasDepu.remove(pelicula);

				try{
					
					//Reescribimos el archivo pero ahora sin el dato eliminado
					this.manipulacionArchivosI.escribir(peliculasDepu);
					return true;

				}catch(ArchivoException e){

					log.error(e.getMessage());
					return false;
				}
				
			
			}

		}
		
		return false;
		
	}


	@Override
	public LinkedList<Pelicula> traerPeliculas() {
		
		try{

			LinkedList<Pelicula> peliculas = this.manipulacionArchivosI.leer();

			// log.info("IMPRESION DE LOS OBJETOS");

			// for(Pelicula pelicula : peliculas){
			// 	log.info(pelicula.toString());
			// }

			return peliculas;

		}catch(ArchivoException e){

			log.error(e.getMessage());
			return new LinkedList<Pelicula>();
		}

		
	}
	
	
}
