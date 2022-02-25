package com.generation.iroomiedb.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.generation.iroomiedb.models.Propiedad;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
	
	@Query("SELECT p FROM Propiedad p WHERE p.nombre=?1")
	Optional<Propiedad> findByNombre (String nombre);
	
}
