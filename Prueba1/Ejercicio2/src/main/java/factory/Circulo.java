package factory;

public class Circulo extends Figura {

	public Circulo(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	void dibujarFigura() {
		System.out.println("Dibujado Circulo "+color);
	}

}
