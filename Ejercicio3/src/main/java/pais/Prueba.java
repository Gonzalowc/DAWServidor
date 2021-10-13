package pais;

public class Prueba {
	public static void main(String[] args) {
		Presidente presidente1 = Presidente.getPresidente("Gonzalo", "Waack Carneado", 2024);
		presidente1.cambioDePresidente("Pepe","Perez",1990);
		Presidente presidente2 = Presidente.getPresidente("Pepito","No lo hace",2004);
		System.out.println(presidente1+"\n"+presidente2+"\n¿Son iguales?"+ presidente1.equals(presidente2));
	}
}
