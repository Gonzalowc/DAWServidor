package org.servidor.uni.services.impl;

import org.servidor.uni.models.usuario.Usuario;
import org.servidor.uni.repository.UsuarioRepository;
import org.servidor.uni.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepo;

	@Override
	public Usuario insertUsuario(Usuario usuario) {
		if(usuario!=null) {
			return usuarioRepo.save(usuario);
		}else {
			return null;
		}
	}
	
	
}
