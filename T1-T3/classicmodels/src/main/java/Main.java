import conector.Conector;
import dao.productImpl;
import objects.Product;

public class Main {
	public static void main(String[] args) {
		productImpl pi = new productImpl();
		Product producto1 = pi.getProduct("S10_1678");
		System.out.println(producto1);
		System.out.println(Conector.getConnection());
		Conector.close();
		
	}
	
}
