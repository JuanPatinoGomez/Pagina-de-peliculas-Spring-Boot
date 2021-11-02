package com.example.demo.model;

public class Pelicula {
	
	private int id;
	private String titulo;
	private String genero;
	private String sinopsis;
	private String urlImagen; //imagenes preferiblemente 720x540
	
	
	public Pelicula() {}
	
	public Pelicula(int id, String titulo, String genero, String sinopsis, String urlImagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.urlImagen = urlImagen;
	}
	
	public Pelicula(String titulo, String genero, String sinopsis, String urlImagen) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.urlImagen = urlImagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	
	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", sinopsis=" + sinopsis + "]";
	}
	
	
	
	

}
