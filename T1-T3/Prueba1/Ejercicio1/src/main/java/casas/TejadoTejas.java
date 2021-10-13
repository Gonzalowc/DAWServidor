package casas;

public class TejadoTejas extends Tejado{

	public TejadoTejas() {
	}
	
	@Override
	public void darSoporte() {
		System.out.println("Doy soporte como Tejado Tejas");
	}

	@Override
	public String toString() {
		return "TejadoTejas []";
	}
	
}
