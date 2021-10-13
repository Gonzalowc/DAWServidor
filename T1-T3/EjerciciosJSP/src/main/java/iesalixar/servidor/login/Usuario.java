package iesalixar.servidor.login;

import java.io.Serializable;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String password;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isUserValid() {
		return usuario.equals("admin") && password.equals("admin");
	}
	public String saludarAlicia() {
		return "Hola Alicia Que tal, Soy el usuario "+usuario;
	}
	
	
}
