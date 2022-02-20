package org.servidor.uni.services.impl;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.alumno.Alumno;
import org.servidor.uni.models.profesor.Profesor;
import org.servidor.uni.repository.AlumnoRepository;
import org.servidor.uni.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImp implements AlumnoService{

	@Autowired
	AlumnoRepository alumnoRepo;

	@Override
	public List<Alumno> getAllAlumnos() {
		return alumnoRepo.findAll();
	}

	@Override
	public Optional<Alumno> findAlumnoById(Long id) {
		if(id!=null) {
			return alumnoRepo.findById(id);			
		}else {
			return null;
		}
	}
	
	@Override
	public Alumno findAlumnoByNif(String nif) {
		if(!nif.equals("") && nif!=null) {
			return alumnoRepo.findByNif(nif);
		}
		return null;
	}

	@Override
	public Alumno insertarAlumno(Alumno alumno) {
		if(alumno !=null && alumno.getId()==null) {
			return alumnoRepo.save(alumno);
		}
		return null;
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		if(alumno !=null && alumno.getId()!=null) {
			return alumnoRepo.save(alumno);
		}
		return null;
	}
}
