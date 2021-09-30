package trenes;

import java.util.Objects;

public class Tren {
	private String modelo;
	private Locomotora locomotora;
	private Conductor conductor;
	
	public Tren(String modelo, Locomotora locomotora, Conductor conductor) {
		this.modelo = modelo;
		this.locomotora = locomotora;
		this.conductor = conductor;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Locomotora getLocomotora() {
		return locomotora;
	}
	
	public void setLocomotora(Locomotora locomotora) {
		this.locomotora = locomotora;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(locomotora, modelo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tren other = (Tren) obj;
		return Objects.equals(locomotora, other.locomotora) && Objects.equals(modelo, other.modelo);
	}

	@Override
	public String toString() {
		return "Tren [modelo=" + modelo + ", locomotora=" + locomotora + ", conductor=" + conductor + "]";
	}
	
	
	
	
}
