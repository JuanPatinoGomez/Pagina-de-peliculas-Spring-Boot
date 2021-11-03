package com.example.demo.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ManipulacionArchivosImpl implements ManipulacionArchivosI{

    Logger log = LoggerFactory.getLogger(ManipulacionArchivosImpl.class);


    @Override
    public LinkedList<Pelicula> leer() throws ArchivoException {
        
        File file = new File("archivopersistencia.txt"); 
		//System.out.println(file.getAbsolutePath());
        //log.info("La direccion en la que busca el archivo" + file.getAbsolutePath());
		BufferedReader br = null;
		FileReader fileReader = null;
		LinkedList<Pelicula> peliculas = new LinkedList<>();
		String linea = "";
		String [] partes;	
		Pelicula pelicula;
		
		try {
			fileReader = new FileReader(file); //Esto genera una excepción FileNotFoundException
			
			br = new BufferedReader(fileReader);
			
			while((linea = br.readLine())!= null){
                // log.info("Linea = " + linea);
				partes = linea.split("♦");
				//System.out.println(partes[1] + " " + partes[0] + " " + partes[2] + " " + Integer.parseInt(partes[3]));
                pelicula = new Pelicula(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4]);
				// log.info("url:" + partes[4]);
				/*persona = new Persona();
				persona.setCedula(partes[2]);
				persona.setNombre(partes[0]);
				persona.setApellido(partes[1]);
				persona.setEdad(Integer.parseInt(partes[3]));
				Date fechanN = DateUtil.convertirDate(partes[4]);
				System.out.println(fechanN);
				String fechaN = DateUtil.convertirFecha(fechanN);
				System.out.println(fechaN);
				persona.setFechaNacimiento(fechaN);
				personas.add(persona);*/
                peliculas.add(pelicula);
			}
			
		} catch (FileNotFoundException e) {
			
			//this.logger.error("No existe el archivo: " + this.rutaArchivo, e);
			System.out.println("No existe el archivo");
			throw new ArchivoException("No existe el archivo" );
			
		} catch (IOException e) {
			
			//this.logger.error("Error al leer el archivo " + this.rutaArchivo, e);
			throw new ArchivoException("Error al leer el archivo");
			
		}finally{
		
			try {
				if(br != null){
					br.close();	
				}
				
			} catch (IOException e) {
				//this.logger.error("Error al cerrar el BufferedReader", e);
				System.out.println("Error al cerrar el BufferedReader");
				throw new ArchivoException("Error al cerrar el BufferedReader");
			}
			try {
				
				if(fileReader != null){
					fileReader.close();
				}
				
			} catch (IOException e) {
				//this.logger.error("Error al cerrar el FileReader", e);
				System.out.println("Error al cerrar el FileReader");
				throw new ArchivoException("Error al cerrar el FileReader");
			}
		}
		
		return peliculas;
    }

    @Override
    public void escribir(LinkedList<Pelicula> listadoPeliculas) throws ArchivoException {

		LinkedList<Pelicula> peliculas = listadoPeliculas;

        FileWriter fichero = null;
	    PrintWriter pw = null;
	    try
	    {
	        fichero = new FileWriter("archivopersistencia.txt");
	        pw = new PrintWriter(fichero);

	            for(Pelicula pelicula: peliculas){
					pw.println(pelicula.formatoArchivo());
				}
	            

	    } catch (Exception e) {
	        throw new ArchivoException("Error al escribir en el archivo");
	        	
	    } finally {
	        try {
	        // Nuevamente aprovechamos el finally para 
	        // asegurarnos que se cierra el fichero.
	        if (null != fichero)
	            fichero.close();
	        } catch (Exception e2) {
	        	throw new ArchivoException("Error al escribir en el archivo");
	        }
	    }
        
    }

	@Override
	public void agregarPeli(Pelicula pelicula) throws ArchivoException {

		FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("archivopersistencia.txt", true);
	            pw = new PrintWriter(fichero);

	            
	            pw.println(pelicula.formatoArchivo());

				log.info("SE AGREGO UNA NUEVA PELICULA");
	        } catch (Exception e) {
	        	throw new ArchivoException("Error al agregar en el archivo");
	        	
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	        	   throw new ArchivoException("Error al agregar en el archivo");
	           }
	        }
		
	}
    
}
