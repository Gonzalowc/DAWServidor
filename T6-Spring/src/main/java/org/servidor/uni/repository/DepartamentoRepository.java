package org.servidor.uni.repository;

import java.util.Optional;

import org.servidor.uni.models.departamento.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	public Departamento findByNombre(String nombre);
	public Optional<Departamento> findById(Long id);
}
