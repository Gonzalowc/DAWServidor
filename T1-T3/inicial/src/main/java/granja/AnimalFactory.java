package granja;

public class AnimalFactory {
	
	public static Animal getAnimal(String typeAnimal) {
		if(typeAnimal.toLowerCase().equals("gato")) {
			return new Gato("NoName-Gato");
		}else if (typeAnimal.toLowerCase().equals("perro")) {
			return new Perro("NoName-Perro");
		}else {
			return new Vaca("NoName-Vaca");
		}
	}
}
