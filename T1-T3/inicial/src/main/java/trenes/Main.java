package trenes;

public class Main {
	public static void main(String[] args) {
		Conductor antonio = new Conductor("Antonio","Fernandez","Calle Miscelaneo 22");
		Locomotora LMT52 = new Locomotora("LMT52",52000,150);
		Tren tren1 = new Tren("AVE",LMT52,antonio);
		ConductorPrimera cp = new ConductorPrimera("pepe", "perez", "Calle miscelaneo 23",10);
		System.out.println(tren1);
		Tren tren2  = new Tren("AVE Maria",LMT52,cp);
		System.out.println(tren2);
	}

}
