package com.generation.iroomiedb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.iroomiedb.models.Propiedad;

@Service
public class PropiedadService {

	private final PropiedadRepository proRepo;
	
	@Autowired
	public PropiedadService(PropiedadRepository proRepo){
		this.proRepo = proRepo;
	}
	
	public List<Propiedad> getPropiedades() {
		return proRepo.findAll();
	}

	public Propiedad getPropiedad(Long idPro) {
		return proRepo.findById(idPro).orElseThrow(()-> new IllegalStateException("La propiedad con el id: " + idPro + "no existe"));
	
	}

	public void deletePropiedad(Long idPro) {
		if(proRepo.existsById(idPro)) {
			proRepo.deleteById(idPro);
		}
		
	}

	public void addPropiedad(Propiedad pro) {
		Optional<Propiedad> prodByName = proRepo.findByNombre(pro.getNombre());
		if(prodByName.isPresent()) { 
			throw new IllegalStateException("EL producto con el nombre " +pro.getNombre()+" ya existe" );
		} else{
			
			proRepo.save(pro);
		}
	}
		

	public void updatePropiedad(Long idPro, String nombre, double precio, String foto, String direccion,
			String municipio, String banios, String habitaciones) {
		if (proRepo.existsById(idPro)) {
			Propiedad p = proRepo.getById(idPro);
			if(nombre != null)p.setNombre(nombre);
			if(precio != 0)p.setPrecio(precio);
			if(foto != null)p.setFoto(foto);
			if(direccion != null)p.setDireccion(direccion);
			if(municipio != null)p.setMunicipio(municipio);
			if(banios != null)p.setBanios(banios);
			if(habitaciones != null)p.setHabitaciones(habitaciones);
			proRepo.save(p);
			
		}else {
			System.out.println("No existe el id"+idPro);
		}//if
		
	}

	

}
