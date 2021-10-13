package factory;

public class Triangulo extends Figura {

	public Triangulo(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	void dibujarFigura() {
		System.out.println("Dibujado Triangulo "+color);
		
	}

}
