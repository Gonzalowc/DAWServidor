package granja;

public abstract class Animal {
	protected String nombre;
	
	public Animal(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void saluda();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
