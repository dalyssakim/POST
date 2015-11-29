package postObject;

public class Sale {

	private ItemList itemList = null;
	private Purchase purchase = null;
	private double charge = 0;
	Sale(){
		this.itemList = new ItemList(); 							// 1.1 create
		this.purchase = new Purchase(); 							// 1.2 create
	}
	
	public void addItem(ProductDescription spec, int quantity){
		
		Item item = new Item(spec, quantity); 						// 3.1 create()
		itemList.addItem(item); 									// 3.2 addItem(item)
	
		charge = purchase.calculateCharge(itemList); 				// 4 charge=calculateCharge()
		

	}
	
	public void discardItem(int id, int quantity){
		itemList.removeItem(id, quantity);							// 1.1 removeItem(id quantity)
		charge = purchase.calculateCharge(itemList);				// 1.2 calculateCharge(itemList)
		
	}
	
	public double getChange(double amount){
		return purchase.getChange(amount, itemList);				// 1.1 change=getChange(amount, itemList)
	}
	
	public ItemList getItemList(){
		return itemList;
	}
	
	public double getCharge(){
		return charge;
	}
	
}
