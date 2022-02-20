package org.servidor.uni.repository;

import org.servidor.uni.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByUserName(String userName);
}
