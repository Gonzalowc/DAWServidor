package org.servidor.uni.controller;

import org.servidor.uni.models.usuario.Usuario;
import org.servidor.uni.models.usuario.UsuarioDTO;
import org.servidor.uni.services.impl.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	UsuarioServiceImp usuarioService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
}
