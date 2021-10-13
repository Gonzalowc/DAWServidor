package objects;

public class Product {
	private String productCode;
	private String productName;
	private String productLine;
	private String productDescription;
	private int quantityInStock;

	public Product(String productCode, String productName, String productLine, String productDescription,
			int quantityInStock) {
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productDescription=" + productDescription + ", quantityInStock=" + quantityInStock + "]";
	}
	
}
