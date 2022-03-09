package org.servidor.uni.services;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.alumno.Alumno;

public interface AlumnoService {	
	public List<Alumno> getAllAlumnos();
	public Optional<Alumno> findAlumnoById(Long id);
	public Alumno insertarAlumno(Alumno alumno);
	public Alumno actualizarAlumno(Alumno alumno);
	public Alumno findAlumnoByNif(String nif);
}
