package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conector.Conector;
import objects.Product;

public class productImpl implements ProductDAO{

	@Override
	public Product getProduct(String name) {
		Connection con2 = Conector.getConnection();
		String sql = "select * from products WHERE productCode = ?";
		
		try(PreparedStatement stmt = con2.prepareStatement(sql)) {
			System.out.println("Ha entrado");
			stmt.setString(1,name);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				System.out.println("Hay producto");
				String productCode = result.getString("productCode");
				String productName= result.getString("productName");
				String productLine = result.getString("productLine");
				String productDescription = result.getString("productDescription");
				int quantityInStock = result.getInt("quantityInStock");
				return new Product(productCode,productName,productLine,productDescription,quantityInStock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("No ha entrado");
		return null;
	}

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createNewproduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(String name, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(String name) {
		// TODO Auto-generated method stub
		
	}
	

	


}
