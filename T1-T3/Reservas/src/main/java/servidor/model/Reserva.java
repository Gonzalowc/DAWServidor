package servidor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable{

	private String fInicio;
	private String fFin;
	private int NPersonas;
	private ArrayList<String> servicios;
	
	public Reserva() {
	}
	public String getfInicio() {
		return fInicio;
	}
	public void setfInicio(String fInicio) {
		this.fInicio = fInicio;
	}
	public String getfFin() {
		return fFin;
	}
	public void setfFin(String fFin) {
		this.fFin = fFin;
	}
	public int getNPersonas() {
		return NPersonas;
	}
	public void setNPersonas(int nPersonas) {
		NPersonas = nPersonas;
	}
	public ArrayList<String> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<String> servicios) {
		this.servicios = servicios;
	}
	
	
	
}
