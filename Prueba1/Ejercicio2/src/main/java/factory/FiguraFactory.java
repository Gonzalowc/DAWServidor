package factory;

public class FiguraFactory {
	public static Figura createFigura(String color, String figura) {
		if (figura.toLowerCase().equals("triangulo")) {
			return new Triangulo(color);
		} else if (figura.toLowerCase().equals("rectangulo")) {
			return new Rectangulo(color);
		} else if (figura.toLowerCase().equals("circulo")) {
			return new Circulo(color);
		} else if (figura.toLowerCase().equals("cuadrado")) {
			return new Cuadrado(color);
		}else {
			return null;
		}
	}
}
