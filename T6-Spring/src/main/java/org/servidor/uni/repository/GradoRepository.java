package org.servidor.uni.repository;

import org.servidor.uni.models.grado.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long>{
	public Grado findByNombre(String nombre);
}
