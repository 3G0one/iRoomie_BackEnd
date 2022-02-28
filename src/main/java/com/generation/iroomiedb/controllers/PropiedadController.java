package com.generation.iroomiedb.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.iroomiedb.models.Propiedad;

import com.generation.iroomiedb.services.PropiedadService;

@RestController
@RequestMapping(path="/api/propiedades/")
@CrossOrigin(origins="*")
public class PropiedadController {
	
	private final PropiedadService proService;

	@Autowired
	public PropiedadController(PropiedadService proService) {
		
		this.proService = proService;
	}//constructorPropiedadService
	
	@GetMapping
	public List<Propiedad> getPropiedades(){
		return proService.getPropiedades();
	}//getPropiedades
	
	@GetMapping(path="{idPro}")
	public Propiedad getPropiedad(@PathVariable ("idPro") Long idPro){
		return proService.getPropiedad(idPro);
	}//getPropiedad
	
	@DeleteMapping(path="{idPro}")
	public void deletePropiedad(@PathVariable ("idPro") Long idPro){
		proService.deletePropiedad(idPro);
	}//Delete
	
	@PostMapping
	public void addPropiedad(@RequestBody Propiedad pro) {
		proService.addPropiedad(pro);
	}
	
	@PutMapping(path= "{idPro}")
	public void updatePropiedad(@PathVariable ("idPro") Long idPro,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) double precio,
			@RequestParam(required=false) String foto,
			@RequestParam(required=false) String direccion,
			@RequestParam(required=false) String municipio,
			@RequestParam(required=false) String banios,
			@RequestParam(required=false) String habitaciones,
			@RequestParam(required=false) String genero
			){
		
		proService.updatePropiedad(idPro, nombre, precio, foto, direccion, municipio, banios, habitaciones, genero);
		
	}
	
	
	
	
	
	

}
