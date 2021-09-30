package granja;

public class Perro extends Animal {

	public Perro(String nombre) {
		super(nombre);
	}

	@Override
	public void saluda() {
		System.out.println("Guau");
	}

}
