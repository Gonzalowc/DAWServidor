package org.servidor.uni.controller;

import java.util.List;

import org.servidor.uni.models.departamento.Departamento;
import org.servidor.uni.models.departamento.DepartamentoDTO;
import org.servidor.uni.services.impl.DepartamentoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImp departamentoService;
	
	@RequestMapping("/departments")
	public String departaments(Model model) {
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		model.addAttribute("contenido", "Productos");
		model.addAttribute("departamentos", departamentos);
		return "departments";
	}
	
	@GetMapping("departments/add")
	public String addDepartmentGet(@RequestParam(required=false, name="error") String error, @RequestParam(required=false, name="dpto") String nombre, Model model) {
		
		DepartamentoDTO dpto= new DepartamentoDTO();
		model.addAttribute("dpto", dpto);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addDepartment";
	}
	
	@PostMapping("/departments/add")
	public String addDepartmentPost(@ModelAttribute DepartamentoDTO dpto, Model model) {
		
		return "redirect:/departments";
	}
	
	@GetMapping("/departments/edit")
	public String editDpto(@RequestParam(name="dpto") String dpto,Model model) {
		
		
		Departamento department = departamentoService.findDepartamentoById(Long.parseLong(dpto));
		model.addAttribute("department", department);
		return "editDepartament";
	}
	
	
	@PostMapping("/departments/edit")
	public String updateDpto(@ModelAttribute Departamento dpto) {
		
		if (departamentoService.actualizarDepartamento(dpto)==null) {
			return "redirect:/departments/edit?error=error&dpto"+dpto.getId();
		}
		return "redirect:/departments";
	}
}
