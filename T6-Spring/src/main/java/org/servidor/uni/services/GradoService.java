package org.servidor.uni.services;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.grado.Grado;

public interface GradoService {
	public List<Grado> getAllGrados();
	public Grado insertarGrado(Grado grado);
	public Grado actualizarGrado(Grado grado);
	public Optional<Grado> findGradoById(Long id);
	public Grado getGradoByName(String nombre);
}
