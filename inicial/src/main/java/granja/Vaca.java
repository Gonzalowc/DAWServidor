package granja;

public class Vaca extends Animal{

	public Vaca(String nombre) {
		super(nombre);
	}

	@Override
	public void saluda() {
		System.out.println("Muuuu");
	}
 
}
