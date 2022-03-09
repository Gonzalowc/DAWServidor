package org.servidor.uni.repository;

import org.servidor.uni.models.alumno.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
	Alumno findByNif(String nif);
	
}
