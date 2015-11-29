package postObject;

public class ProductDescription {
	
	private int id;
	private String productName;
	private double cost;
	private int stock;
	
	ProductDescription(int id, String productName, double cost, int stock){
		this.id = id;
		this.productName = productName;
		this.cost = cost;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getCost() {
		return cost;
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

}
