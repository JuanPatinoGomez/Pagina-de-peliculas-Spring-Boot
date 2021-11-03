package com.example.demo.model;

import java.util.LinkedList;


public interface ManipulacionArchivosI {
    
    LinkedList<Pelicula> leer() throws ArchivoException;
    void escribir(LinkedList<Pelicula> listadoPeliculas) throws ArchivoException;
    void agregarPeli(Pelicula pelicula)throws ArchivoException;

}
