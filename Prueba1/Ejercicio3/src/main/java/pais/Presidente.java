package pais;

public class Presidente {
	private String nombre;
	private String apellidos;
	private int anioEleccion;
	private static Presidente presidente = null;
	
	private Presidente() {
		nombre="";
		apellidos="";
		anioEleccion=0;
	}
	public static Presidente getPresidente(String nombre, String apellidos, int anioEleccion) {
		if(presidente==null) {
			presidente= new Presidente();
			presidente.setNombre(nombre);
			presidente.setApellidos(apellidos);
			presidente.setAnioEleccion(anioEleccion);
		}
		return presidente;
	}

	public void cambioDePresidente(String nombre, String apellidos, int anioEleccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anioEleccion = anioEleccion;
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
	public int getAnioEleccion() {
		return anioEleccion;
	}
	public void setAnioEleccion(int anioEleccion) {
		this.anioEleccion = anioEleccion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anioEleccion;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Presidente other = (Presidente) obj;
		if (anioEleccion != other.anioEleccion)
			return false;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Presidente [nombre=" + nombre + ", apellidos=" + apellidos + ", anioEleccion=" + anioEleccion + "]";
	}
	
}
