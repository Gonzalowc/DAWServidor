package pizzeria;

public class PizzaFactory {
	public static Pizza getPizza(String nombre) {
		if(nombre.toLowerCase().equals("hawaiana")) {
			Hawaiana h = new Hawaiana("Hawaiana");
			h.addIngrediente(new Ingrediente("Piña"));
			h.addIngrediente(new Ingrediente("Queso"));
			h.addIngrediente(new Ingrediente("Jamon York"));
			return h;
		}else if(nombre.toLowerCase().equals("barbacoa")) {
			Barbacoa c = new Barbacoa("Barbacoa");
			c.addIngrediente(new Ingrediente("Barbacoa"));
			c.addIngrediente(new Ingrediente("Queso"));
			c.addIngrediente(new Ingrediente("Bacon"));
			c.addIngrediente(new Ingrediente("Carne picada"));
			return c;
		}else if(nombre.toLowerCase().equals("carbonara")) {
			Carbonara cb = new Carbonara("Carbonara");
			cb.addIngrediente(new Ingrediente("Nata"));
			cb.addIngrediente(new Ingrediente("Champiñones"));
			cb.addIngrediente(new Ingrediente("Pollo"));
			return cb;
		}
		return null;
	}
}
