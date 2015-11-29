package postObject;

public class Item {

	private int quantity;
	private ProductDescription spec;
	
	Item(ProductDescription spec, int quantity){
		this.spec = spec;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDescription getSpec() {
		return spec;
	}

	public void setSpec(ProductDescription spec) {
		this.spec = spec;
	}


}
