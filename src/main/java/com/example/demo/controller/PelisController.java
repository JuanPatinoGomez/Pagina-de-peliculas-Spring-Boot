package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.InformacionI;
import com.example.demo.model.Pelicula;


@Controller
@RequestMapping("/inicio")
public class PelisController {
	
	private Logger log = LoggerFactory.getLogger(PelisController.class);
	
	//Se inyecta la implementación
	@Autowired
	private InformacionI informacionI;

	
	@GetMapping("/home")
	public ModelAndView inicio() {
		
		informacionI.peliculasIniciales();
		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("peliculas", informacionI.traerPeliculas());
		
		return modelAndView;
	}
	
	@GetMapping("/vistalista")
	public ModelAndView vista_linea() {
		
		ModelAndView modelAndView = new ModelAndView("vista_tabla");
		modelAndView.addObject("peliculas", informacionI.traerPeliculas());
		
		return modelAndView;
	}
	
	@GetMapping("/form")
	public String formulario(Model model) {
		
		model.addAttribute("pelicula", new Pelicula());
		
		return "form_nueva_peli";
	}
	
	@PostMapping("/nuevapelicula")
	public String agregarPelicula(Pelicula pelicula) {
		
		boolean resultado = informacionI.agregarPelicula(pelicula);
		
		this.log.info("El resultado de agregar una nueva pelicula es: " + resultado);
		
		return "redirect:/inicio/home";
		
	}
	
	@GetMapping("/eliminarpeli")
	public String eliminarPelicula(@RequestParam(name = "id", required=true) int id) {
		
		boolean resultado = informacionI.eliminarPelicula(id);
		
		this.log.info("El resultado de elimnar una pelicula es: " + resultado);
		
		return "redirect:/inicio/vistalista";
	}
	
	
}
