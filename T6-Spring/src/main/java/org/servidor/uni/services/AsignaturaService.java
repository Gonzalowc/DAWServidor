package org.servidor.uni.services;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.asignatura.Asignatura;

public interface AsignaturaService {
	public List<Asignatura> getAllAsignaturas();
	public Optional<Asignatura> findAsignaturaById(Long id);
	public Asignatura getAsignaturaByName(String nombre);
	public Asignatura insertarAsignatura(Asignatura asignatura);
	public Asignatura actualizarAsignatura(Asignatura asignatura);
}
