package granja;

public class Gato extends Animal{

	public Gato(String nombre) {
		super(nombre);
	}
	
	@Override
	public void saluda() {
		System.out.println("Miau");
		
	}
	

}
