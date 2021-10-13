package object;

import Singleton.Deposito;

public class Cubo {
	private int litros = 0;
	
	
	public Cubo(int litros) {
		this.litros = litros;
	}
	
	public void vaciar() {
		Deposito.getDeposito();
		Deposito.llenar(litros);
	}
	public void llenar() {
		litros = Deposito.vaciar(litros);
	}
}
