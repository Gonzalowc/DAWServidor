package org.servidor.uni.models.asignatura;

import java.io.Serializable;

public class AsignaturaDTO implements Serializable{
	private String nombre;
	private Double creditos;
	private String tipo;
	private Integer curso;
	private Integer cuatrimestre;
	private Long id_profesor;
	private Long id_grado;
	
	public AsignaturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Integer getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(Integer cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public Long getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(Long id_profesor) {
		this.id_profesor = id_profesor;
	}

	public Long getId_grado() {
		return id_grado;
	}

	public void setId_grado(Long id_grado) {
		this.id_grado = id_grado;
	}
}
