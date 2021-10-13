package trenes;

public class ConductorPrimera extends Conductor{
	private int antiwedad;
	
	public ConductorPrimera(String nombre, String apellidos, String direccion, int antiwedad) {
		super(nombre, apellidos, direccion);
		this.antiwedad = antiwedad;
	}

	@Override
	public String toString() {
		return "ConductorPrimera ["+super.toString()+", antiwedad=" + antiwedad + "]";
	}

	

}
