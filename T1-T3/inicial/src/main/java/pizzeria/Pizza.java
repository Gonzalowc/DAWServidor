package pizzeria;

import java.util.ArrayList;

public abstract class Pizza {
	protected ArrayList<Ingrediente> ingredientes;

	public Pizza() {
		ingredientes = new ArrayList<Ingrediente>();
	}
	public void addIngrediente(Ingrediente ingrediente) {
		ingredientes.add(ingrediente);
	}
	public void deleteIngrediente(Ingrediente ingrediente) {
		for (int i = 0; i < ingredientes.size(); i++) {
			if(ingredientes.get(i).equals(ingrediente)) {
				ingredientes.remove(i);
				break;
			}
		}
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Pizza [ingredientes=" + ingredientes + "]";
	}
	
	
}
