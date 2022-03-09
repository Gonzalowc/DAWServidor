package org.servidor.uni.controller;

import java.util.List;

import org.servidor.uni.models.DepartamentoProfesorDTO;
import org.servidor.uni.models.departamento.Departamento;
import org.servidor.uni.models.departamento.DepartamentoDTO;
import org.servidor.uni.models.profesor.Profesor;
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
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImp departamentoService;
	
	@Autowired
	ProfesorServiceImp profesorService;
	
	@RequestMapping("/departments")
	public String departaments(Model model) {
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		model.addAttribute("contenido", "Productos");
		model.addAttribute("departamentos", departamentos);
		return "departments";
	}
	
	@GetMapping("/departments/add")
	public String addDepartmentGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="dpto") String nombre,
			Model model) {
		
		DepartamentoDTO dpto = new DepartamentoDTO();
		
		model.addAttribute("dpto", dpto);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addDepartment";
	}
	
	
	@PostMapping("/departments/add")
	public String addDepartmentPost(@ModelAttribute DepartamentoDTO dpto,Model model) {
		
		Departamento dptoBD = new Departamento();
		dptoBD.setNombre(dpto.getNombre());
		
		if (departamentoService.insertarDepartamento(dptoBD)==null) {
			return "redirect:/departments/add?error=Existe&dpto="+dpto.getNombre();
		}
		
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
	
	@GetMapping("/departments/profesores")
	public String profesoresDepartamento(
			@RequestParam(required=false,name="dpto") String dpto,
			@RequestParam(required=false,name="exito") String exito,
			Model model) {
		
		Departamento dptoEntity = departamentoService.findDepartamentoById(Long.parseLong(dpto));
		
		if (dpto==null || dptoEntity == null) {
			return "redirect:/departments";
		}
		if(exito!=null) {
			model.addAttribute("exito", exito);
		}
		
		model.addAttribute("departamento", dptoEntity);		
		
		return "profesoresDepartment";
	}
	
	
	@GetMapping("/departments/profesor/delete")
	public String borrarProfesorDepartamento(			
			@RequestParam(required=false,name="prof") String prof,
			Model model) {
		
		Profesor profEntity = profesorService.findProfesorById(Long.parseLong(prof)).get();
		Long dptoId = profEntity.getDepartamento().getId();
		
		profEntity.setDepartamento(null);
		
		profesorService.actualizarProfesor(profEntity);
		
		return "redirect:/departments/profesores?dpto="+dptoId+"&exito=delProDep";
		
	}
	
	@GetMapping("/departments/addprofesor")
	public String addProfDepartGet(@RequestParam(required=false,name="error") String error, @RequestParam(required=false,name="id_depart") String id_depart, Model model) {
		
		DepartamentoProfesorDTO profDepart = new DepartamentoProfesorDTO();
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		List<Profesor> profesores = profesorService.getAllProfesores();
		model.addAttribute("profDepart", profDepart);
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("profesores", profesores);
		model.addAttribute("error",error);
		if(id_depart!=null) {
			model.addAttribute("id_depart", id_depart);
		}
		return "addProfDepartamento";
	}
	
	@PostMapping("/departments/addprofesor")
	public String addProfDepartPost(@ModelAttribute DepartamentoProfesorDTO profDepart,Model model) {
		
		Departamento departamento = departamentoService.findDepartamentoById(profDepart.getId_departamento());
		Profesor profesor = profesorService.findProfesorById(profDepart.getId_profesor()).get();
		
		if(departamento != null && profesor != null) {
			
			profesor.setDepartamento(departamento);
			profesorService.actualizarProfesor(profesor);
			
			return "redirect:/departments/profesores?dpto="+departamento.getId();

		} else {	
			return "redirect:/departments/addprofesor";
		}

	}
}
