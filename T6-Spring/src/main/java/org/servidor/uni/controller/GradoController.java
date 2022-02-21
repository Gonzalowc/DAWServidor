package org.servidor.uni.controller;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.grado.Grado;
import org.servidor.uni.models.grado.GradoDTO;
import org.servidor.uni.services.impl.GradoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/grados")
public class GradoController {

	@Autowired
	GradoServiceImp gradoService;
	
	@RequestMapping("/")
	public String grados(Model model) {
		
		List<Grado> grados = gradoService.getAllGrados();
		
		model.addAttribute("grados",grados);
		return "grados";
	}


	@GetMapping("/add")
	public String addGradoGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="grado") String nombre,
			Model model) {
		
		GradoDTO grado = new GradoDTO();
		
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addGrado";
	}
	
	
	@PostMapping("/add")
	public String addGradoPost(@ModelAttribute GradoDTO grado,Model model) {
		
		Grado gradoBD = new Grado();
		gradoBD.setNombre(grado.getNombre());
		
		if (gradoService.insertarGrado(gradoBD)==null) {
			return "redirect:/grados/add?error=Existe&grado="+grado.getNombre();
		}
		
		return "redirect:/grados";
	}
	
	@GetMapping("/edit")
	public String editGrado(@RequestParam(name="grado") String grado, @RequestParam(name="error",required=false) String error, Model model) {
		
		
		Optional<Grado> grad = gradoService.findGradoById(Long.parseLong(grado));
		model.addAttribute("grado", grad.get());
		model.addAttribute("error", error);
		return "editGrado";
	}
	
	
	@PostMapping("/edit")
	public String updateGrado(@ModelAttribute Grado grado) {
		
		if (gradoService.actualizarGrado(grado)==null) {
			return "redirect:/grados/edit?error=error&grado="+grado.getId();
		}
		return "redirect:/grados";
	}
}
