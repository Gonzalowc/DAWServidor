package org.servidor.uni.services;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.profesor.Profesor;

public interface ProfesorService {
	public List<Profesor> getAllProfesores();
	public Profesor insertarProfesor(Profesor profesor);
	public Profesor actualizarProfesor(Profesor profesor);
	public Optional<Profesor> findProfesorById(Long id);
	public Profesor findProfesorByNif(String nif);
}
