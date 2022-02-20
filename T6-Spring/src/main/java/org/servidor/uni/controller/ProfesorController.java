package org.servidor.uni.controller;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.departamento.Departamento;
import org.servidor.uni.models.profesor.Profesor;
import org.servidor.uni.models.profesor.ProfesorDTO;
import org.servidor.uni.services.impl.DepartamentoServiceImp;
import org.servidor.uni.services.impl.ProfesorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {
	
	@Autowired
	ProfesorServiceImp profesorService;
	
	@Autowired
	DepartamentoServiceImp departService;
	
	@GetMapping("/")
	public String alumnos(Model model) {
		List<Profesor> profesores = profesorService.getAllProfesores();
		model.addAttribute("profesores", profesores);
		return "profesores";
	}

	@GetMapping("/edit")
	public String editProf(@RequestParam(name="prof") String prof,Model model) {
		
		Optional<Profesor> profesor = profesorService.findProfesorById(Long.parseLong(prof));
		List<Departamento> departamentos = departService.getAllDepartments();
		model.addAttribute("profesor", profesor.get());
		model.addAttribute("departamentos", departamentos);
		return "editProfesor";
	}
	
	
	@PostMapping("/edit")
	public String updateProf(@ModelAttribute Profesor prof) {
		if (profesorService.actualizarProfesor(prof)==null) {
			return "redirect:/profesores/edit?error=error&prof"+prof.getId();
		}
		return "redirect:/profesores/";
	}
	
	@GetMapping("/add")
	public String addProfesorGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="prof") String nombre,
			Model model) {
		
		ProfesorDTO prof = new ProfesorDTO();
		List<Departamento> departamentos = departService.getAllDepartments();
		
		model.addAttribute("prof", prof);
		model.addAttribute("departamentos",departamentos);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addProfesor";
	}
	
	
	@PostMapping("/add")
	public String addProfesorPost(@ModelAttribute ProfesorDTO prof,Model model) {
		if(profesorService.findProfesorByNif(prof.getNif())==null) {
			Profesor profDTO = new Profesor(prof, departService.findDepartamentoById(prof.getId_departamento()));		
		if (profesorService.insertarProfesor(profDTO)==null) {
			return "redirect:/profesores/add?error=Existe&prof="+prof.getNombre();
		}
		
		return "redirect:/profesores/";
		}else {
			return "redirect:/profesores/add?error=ExisteNif&prof="+prof.getNif();
		}
		
	}
}
