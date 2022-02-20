package org.servidor.uni.services;

import java.util.List;

import org.servidor.uni.models.departamento.Departamento;

public interface DepartamentoService {
	public List<Departamento> getAllDepartments();
	public Departamento getDepartamentByName(String nombre);
	public Departamento insertarDepartamento(Departamento departamento);
	public Departamento actualizarDepartamento(Departamento departamento);
	public Departamento findDepartamentoById(Long id);
}
