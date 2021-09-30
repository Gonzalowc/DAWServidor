package granja;

public class Principal {
	public static void main(String[] args) {
		Animal animal1 = AnimalFactory.getAnimal("gato");
		Animal animal2 = AnimalFactory.getAnimal("perro");
		Animal animal3 = AnimalFactory.getAnimal("");
		animal1.saluda();
		animal2.saluda();
		animal3.saluda();
	}
}
