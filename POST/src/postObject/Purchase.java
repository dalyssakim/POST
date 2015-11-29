package postObject;

public class Purchase {

	
	public double calculateCharge(ItemList itemList){
		double charge = 0;
		
		for(int i = 0; i < itemList.size(); i++){
			charge += itemList.getItem(i).getSpec().getCost() * itemList.getItem(i).getQuantity();
		}
	

		return charge;
	}
	
	public double getChange(double amount, ItemList itemList){
		double charge = calculateCharge(itemList);
		double change = amount - charge;
		
		// should delete printing code
		if(change >= 0){
	//		System.out.println("Change : " + change);
		}
		else{
			System.out.println("Not enough money");
		}
		
		return change;
		
	}
}
