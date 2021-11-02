package com.example.demo.model;

import java.util.LinkedList;

public interface InformacionI {
	
	void peliculasIniciales();
	
	boolean agregarPelicula(Pelicula pelicula);
	boolean eliminarPelicula(int id);
	
	LinkedList<Pelicula> traerPeliculas();

}
