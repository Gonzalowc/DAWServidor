package dao;

import java.util.List;

import objects.Product;

public interface ProductDAO {
	Product getProduct(String name);
	List<Product> getProduct();
	void createNewproduct(Product product);
	void updateProduct(String name, Product product);
	void deleteProduct(String name);
}
