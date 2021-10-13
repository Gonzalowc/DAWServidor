package trenes;

import java.util.Objects;

public class Locomotora {
	String modelo;
	int potencia;
	int longitud;
	
	public Locomotora(String modelo, int potencia, int longitud) {
		this.modelo = modelo;
		this.potencia = potencia;
		this.longitud = longitud;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	@Override
	public int hashCode() {
		return Objects.hash(longitud, modelo, potencia);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locomotora other = (Locomotora) obj;
		return longitud == other.longitud && Objects.equals(modelo, other.modelo) && potencia == other.potencia;
	}
	@Override
	public String toString() {
		return "Locomotora [modelo=" + modelo + ", potencia=" + potencia + ", longitud=" + longitud + "]";
	}
	
	
	
	
}
