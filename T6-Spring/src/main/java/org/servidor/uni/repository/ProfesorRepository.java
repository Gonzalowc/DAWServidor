package org.servidor.uni.repository;

import org.servidor.uni.models.profesor.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{
	public Profesor findByNif(String nif);
}
