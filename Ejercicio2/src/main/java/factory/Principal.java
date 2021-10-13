package factory;

public class Principal {
	public static void main(String[] args) {
		Triangulo triangulo = (Triangulo) FiguraFactory.createFigura("Rojo", "triangulo");
		Cuadrado cuadrado = (Cuadrado) FiguraFactory.createFigura("Azul", "cuadrado");
		Rectangulo rectangulo = (Rectangulo) FiguraFactory.createFigura("Verde", "rectangulo");
		Circulo circulo = (Circulo) FiguraFactory.createFigura("Amarillo", "circulo");
		triangulo.dibujarFigura();
		cuadrado.dibujarFigura();
		rectangulo.dibujarFigura();
		circulo.dibujarFigura();
	}
}
