package pizzeria;

public class Main {
	public static void main(String[] args) {
		Pizza carbonara = PizzaFactory.getPizza("carbonara");
		System.out.println(carbonara);
	}
}
