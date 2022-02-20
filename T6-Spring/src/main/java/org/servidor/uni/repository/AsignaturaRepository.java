package org.servidor.uni.repository;

import org.servidor.uni.models.asignatura.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	public Asignatura findByNombre(String nombre);
}
