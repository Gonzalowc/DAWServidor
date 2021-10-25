package servidor.controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario  implements Serializable{
	String usuario;
	String nombre;
	String apellidos;
	String correo;
	String curso;
	ArrayList<String> modulos;
	
	public Usuario() {}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public ArrayList<String> getModulos() {
		return modulos;
	}
	public void setModulos(ArrayList<String> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", curso=" + curso + ", modulos=" + modulos + "]";
	}
	
	
}
