package org.servidor.uni.controller;

import java.util.List;
import java.util.Optional;

import org.servidor.uni.models.alumno.Alumno;
import org.servidor.uni.models.alumno.AlumnoDTO;
import org.servidor.uni.models.departamento.Departamento;
import org.servidor.uni.models.profesor.Profesor;
import org.servidor.uni.models.profesor.ProfesorDTO;
import org.servidor.uni.services.impl.AlumnoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

		@Autowired
		AlumnoServiceImp alumnoService;
		
		@GetMapping("/")
		public String alumnos(Model model) {
			List<Alumno> alumnos = alumnoService.getAllAlumnos();
			System.out.println(alumnos);
			model.addAttribute("alumnos", alumnos);
			
			return "alumnos";
		}
		

		@GetMapping("/asignaturas")
		public String alumnosMatricula(@RequestParam(required = false, name = "codigo") String codigo, Model model) {

			// Obtengo el parámetro de la URL (en caso de no esta vuelvo a la lista de
			// asignaturas
			if (codigo == null) {
				return "redirect:/alumnos/";
			}
			
			
			Optional<Alumno> alumno = alumnoService.findAlumnoById(Long.parseLong(codigo));
			model.addAttribute("alumno",alumno.get());		
			return "alumnosAsignaturas";
		}
		
		@GetMapping("/edit")
		public String editProf(@RequestParam(name="alumn") String alumn,Model model) {
			
			Optional<Alumno> profesor = alumnoService.findAlumnoById(Long.parseLong(alumn));
			model.addAttribute("alumno", profesor.get());
			return "editAlumno";
		}
		
		
		@PostMapping("/edit")
		public String updateProf(@ModelAttribute Alumno alumn) {
			if (alumnoService.actualizarAlumno(alumn)==null) {
				return "redirect:/alumnos/edit?error=error&prof"+alumn.getId();
			}
			return "redirect:/alumnos/";
		}
		
		@GetMapping("/add")
		public String alumnosInsertarGet(@RequestParam(required=false,name="error") String error,
				@RequestParam(required=false,name="alumno") String alumno,
				Model model) {
			
			AlumnoDTO alumnoDTO = new AlumnoDTO();
			model.addAttribute("alumno", alumnoDTO);
			model.addAttribute("error", error);
			return "addAlumno";
			
		}
		
		@PostMapping("/add")
		public String alumnosInsertarPost(@ModelAttribute AlumnoDTO alumnoDTO,Model model) {
			if(alumnoService.findAlumnoByNif(alumnoDTO.getNif())==null) {
				Alumno alumn = new Alumno(alumnoDTO);		
				System.out.println("pasa por aqui");
				if (alumnoService.insertarAlumno(alumn)==null) {
					return "redirect:/alumnos/add?error=Existe&alumno="+alumnoDTO.getNombre();
				}else {
					return "redirect:/alumnos/";					
				}
			}else {
				return "redirect:/alumnos/add?error=ExisteNif&alumno="+alumnoDTO.getNif();
			}
			
		}
}
