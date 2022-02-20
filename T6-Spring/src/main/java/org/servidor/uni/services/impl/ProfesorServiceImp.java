package org.servidor.uni.services.impl;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.profesor.Profesor;
import org.servidor.uni.repository.ProfesorRepository;
import org.servidor.uni.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImp implements ProfesorService{

	@Autowired
	ProfesorRepository profesorRepo;

	@Override
	public List<Profesor> getAllProfesores() {
		return profesorRepo.findAll();
	}

	@Override
	public Profesor insertarProfesor(Profesor profesor) {
		if(profesor !=null && profesor.getId()== null) {
			return profesorRepo.save(profesor);
		}else {
			return null;
		}
	}

	@Override
	public Profesor actualizarProfesor(Profesor profesor) {
		if(profesor !=null && profesor.getId()!=null) {
			return profesorRepo.save(profesor);			
		}else {
			return null;
		}
	}

	@Override
	public Optional<Profesor> findProfesorById(Long id) {
		if(id!=null) {
			return profesorRepo.findById(id);
		}else {
			return null;
		}
	}

	@Override
	public Profesor findProfesorByNif(String nif) {
		if(!nif.equals("") && nif!=null) {
			return profesorRepo.findByNif(nif);
		}
		return null;
	}
	
}
