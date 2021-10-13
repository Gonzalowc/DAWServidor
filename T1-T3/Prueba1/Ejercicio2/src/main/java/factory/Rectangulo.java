package factory;

public class Rectangulo extends Figura {

	public Rectangulo(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	void dibujarFigura() {
		System.out.println("Dibujado Rectangulo "+color);		
	}

}
