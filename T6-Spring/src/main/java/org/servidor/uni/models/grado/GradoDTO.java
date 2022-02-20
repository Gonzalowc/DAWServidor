package org.servidor.uni.models.grado;

import java.io.Serializable;

public class GradoDTO implements Serializable {
	
	private String nombre;

	public GradoDTO() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
