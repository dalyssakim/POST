package postObject;

import java.util.ArrayList;

public class ProductCatalog {
	
	private static ProductCatalog catalog = null;
	private ArrayList<ProductDescription> specs;
	
	private ProductCatalog(){
		
	}
	
	public static ProductCatalog getProductCatalog(){
		if(catalog == null){
			catalog = new ProductCatalog();
		}
		
		return catalog;
	}
	
	public void setProductDescription(ArrayList<ProductDescription> specs){
		this.specs = specs;
	}
	
	public ProductDescription getItemSpec(int id){
		
		ProductDescription spec = null;
		
		for(int i = 0; i < specs.size(); i++){
			if(specs.get(i).getId() == id){
				spec = specs.get(i);				// 2.1[i:1...#]spec=get(i) & 2.3[i:1...#]spec=get(i)
				return spec;
			}
		}
		
		return spec;
	}
	
	public int size(){
		return specs.size();
	}
	

}
