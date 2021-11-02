package com.example.demo.model;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

@Component
public class InformacionImpl implements InformacionI{
	
	private int contadorId = 0;
	public LinkedList<Pelicula> peliculasLinkedList = new LinkedList<Pelicula>();
	
	
	public void peliculasIniciales() {
		
		if(this.peliculasLinkedList.size() == 0) {
			
			agregarPelicula(new Pelicula("Venom: Carnage liberado", "Acción/Ciencia ficción", 
					"Después de encontrar un cuerpo anfitrión en el periodista de investigación Eddie Brock, el simbionte alienígena debe enfrentarse a un nuevo enemigo, Carnage, el alter ego del asesino en serie Cletus Kasady.", 
					"https://archivos-cms.cinecolombia.com/images/_aliases/exhibition_banner_mobile/5/4/1/1/21145-1-esl-CO/VNM2-6-Banner-movil.jpg"));
			
			agregarPelicula(new Pelicula("Duna", "Ciencia ficción/Aventura",
					"Arrakis, también denominado \"Dune\", se ha convertido en el planeta más importante del universo. A su alrededor comienza una gigantesca lucha por el poder que culmina en una guerra interestelar.",
					"https://archivos-cms.cinecolombia.com/images/_aliases/exhibition_banner_mobile/8/3/9/0/20938-1-esl-CO/800x600.jpg"));
			
			agregarPelicula(new Pelicula("Ron da error", "Animación/cine familiar",
					"Barney, un niño de 11 años, descubre que su amigo robot no funciona del todo porque ha sido dañado durante el transporte para su entrega.",
					"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2021/10/ron-da-error-2507269.jpg?itok=8RO4smVL"));
			
			agregarPelicula(new Pelicula("Los locos Addams 2", "Animación/Fantasía",
					"Morticia da a luz a un bebé, y la familia le pone un nombre: Pubis. Sus hermanos, Miércoles y Pugsley, pronto sienten celos del recién nacido e intentan acabar con él.",
					"https://i1.wp.com/modogeeks.com/wp-content/uploads/2020/10/locos-addams-2.jpg?fit=958%2C773&ssl=1"));
			
			agregarPelicula(new Pelicula("Sin tiempo para morir", "Acción/Aventura",
					"EL legendario espía James Bond ha dejado el servicio activo. Su paz dura poco ya que su viejo amigo Felix Leiter de la CIA aparece pidiendo ayuda, lo que lleva a Bond al rastro de un misterioso villano armado con nueva tecnología peligrosa.",
					"https://media.vandalsports.com/i/640x360/10-2021/2021104172234_1.jpg"));
		}
		
		
	}
	
	
	public boolean agregarPelicula(Pelicula pelicula) {
		
		pelicula.setId(contadorId); //Se le agrega el id
		
		contadorId++; //El id que tendra la siguiente pelicula
		
		return this.peliculasLinkedList.add(pelicula);
		
		
		
	}
	
	public boolean eliminarPelicula(int id) {
		
		
		for(Pelicula pelicula : this.peliculasLinkedList) {
			
			if(pelicula.getId() == id) {
				return this.peliculasLinkedList.remove(pelicula);
			
			}
		}
		
		return false;
		
	}


	@Override
	public LinkedList<Pelicula> traerPeliculas() {
		
		return this.peliculasLinkedList;
	}
	
	
}
