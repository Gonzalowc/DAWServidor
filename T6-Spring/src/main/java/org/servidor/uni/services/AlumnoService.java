package org.servidor.uni.services;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.alumno.Alumno;
import org.servidor.uni.models.profesor.Profesor;

public interface AlumnoService {	
	public List<Alumno> getAllAlumnos();
	public Alumno insertarAlumno(Alumno alumno);
	public Alumno actualizarAlumno(Alumno alumno);
	public Optional<Alumno> findAlumnoById(Long id);
	public Alumno findAlumnoByNif(String nif);
}
