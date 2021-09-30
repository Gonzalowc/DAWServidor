package Singleton;

public class Deposito {

//cantidad estatica que guarda algo del objeto singleton
	private static int cantidad = 0;
//Mismo objeto instanciado en static para que solo se cree una unica intancia y no varias.
//Es decir, que cada vez que se haga un deposito static 
	private static Deposito deposito = null;
	
//Clase que instancia el singleton
	public static Deposito getDeposito() {
		if(deposito == null) {
			deposito = new Deposito();
			
		}
		return deposito;
	}
	
	//clases que modifica los atributos como la cantidad
	public static int llenar(int litros) {
		cantidad+=litros;
		return cantidad;
	}
	//clases que modifica los atributos como la cantidad
	public static int vaciar(int litros) {
		cantidad-=litros;
		return cantidad;
	}
}
