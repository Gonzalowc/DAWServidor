package factory;

public class Cuadrado extends Figura {

	public Cuadrado(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	void dibujarFigura() {
		System.out.println("Dibujado Cuadrado "+color);
	}

}
