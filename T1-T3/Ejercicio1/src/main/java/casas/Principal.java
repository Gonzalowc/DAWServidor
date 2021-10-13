package casas;

public class Principal {
public static void main(String[] args) {
	Pared pared1 = new Pared(100);
	Pared pared2 = new Pared(200);
	Pared pared3 = new Pared(300);
	Pared pared4 = new Pared(400);
	Tejado tejado = new Tejado();
	TejadoTejas tejadotejas = new TejadoTejas();
	Casa casa1 = new Casa(1500,tejado,pared1,pared3,pared2,pared4);
	casa1.getTejado().darSoporte();
	Casa casa2 = new Casa(1500,tejadotejas,pared1,pared3,pared2,pared4);
	casa2.getTejado().darSoporte();
	System.out.println(casa1);
	System.out.println(casa2);
}
}
