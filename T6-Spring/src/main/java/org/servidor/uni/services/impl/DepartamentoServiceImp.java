package org.servidor.uni.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.servidor.uni.models.departamento.Departamento;
import org.servidor.uni.repository.DepartamentoRepository;
import org.servidor.uni.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImp implements DepartamentoService{
	
	@Autowired
	DepartamentoRepository departamentoRepo;

	@Override
	public List<Departamento> getAllDepartments() {
		List<Departamento> departamentos = departamentoRepo.findAll();
		if(departamentos !=null && departamentos.size()>0) {
			return departamentos;
		}else {
			return new ArrayList<Departamento>();
		}
	}

	@Override
	public Departamento getDepartamentByName(String nombre) {
		if(nombre!=null) {
			return departamentoRepo.findByNombre(nombre);
			
		}else {
			return null;
		}
	}

	@Override
	public Departamento insertarDepartamento(Departamento departamento) {
		if(departamento!=null && getDepartamentByName(departamento.getNombre()) == null) {
			return departamentoRepo.save(departamento);
		}else {
			return null;
		}
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) {
		if(departamento !=null && departamento.getId()!=null && departamento.getNombre()!=null) {
			return departamentoRepo.save(departamento);
		} else {
		return null;		
	}
	}

	@Override
	public Departamento findDepartamentoById(Long id) {
		return departamentoRepo.findById(id).get();
	}

}
